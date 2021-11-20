package chatserver;

import chat.*;
import io.grpc.*;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatServer {

    public static final Logger logger = Logger.getLogger(ChatServer.class.getName());
    public static final String serverIP = "localhost";
    public static int serverPort = 9002;

    public static final String ringManagerIP = "localhost";
    public static final int ringManagerPort = 9000;

    public static final ConcurrentHashMap<UserID, StreamObserver<ChatMessage>> clients = new ConcurrentHashMap<>();

    public static void main(String[] args) throws Exception {
        ManagedChannel channelEnroll = null;
        ManagedChannel channelBroadcast = null;
        try {
            if (args.length == 1) serverPort = Integer.parseInt(args[0]);

            // Setup Channel to Ring Manager
            channelEnroll = ManagedChannelBuilder.forAddress(ringManagerIP, ringManagerPort)
                    // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                    // needing certificates.
                    .usePlaintext()
                    .build();

            EnrollGrpc.EnrollBlockingStub blockingStubEnroll = EnrollGrpc.newBlockingStub(channelEnroll);

            EndPoint next = blockingStubEnroll.enroll(chat.EndPoint.newBuilder().setIp(serverIP).setPort(serverPort).build());

            System.out.println("Next: " + next.getIp() + ":" + next.getPort());

            if (channelEnroll != null) {
                logger.log(Level.INFO, "Shutdown channel to Ring Manager.");
                channelEnroll.shutdown().awaitTermination(5, TimeUnit.SECONDS);
            }

            // Setup Channel to next Server
            channelBroadcast = ManagedChannelBuilder.forAddress(next.getIp(), next.getPort())
                    // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                    // needing certificates.
                    .usePlaintext()
                    .build();

            final BroadcastGrpc.BroadcastStub nonBlockingStubBroadcast = BroadcastGrpc.newStub(channelBroadcast);

            final Server svc = ServerBuilder.forPort(serverPort)
                    .addService(new ChatServerClient(nonBlockingStubBroadcast))
                    .addService(new ChatServerServer(nonBlockingStubBroadcast))
                    .build()
                    .start();

            logger.info("Server started, listening on " + serverPort + "...");

            System.err.println("*** server await termination");

            svc.awaitTermination();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (channelBroadcast != null) {
            logger.log(Level.INFO, "Shutdown channel to Next Server in Ring.");
            channelBroadcast.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        }
    }

    public static void broadcastMessageToClients(String fromUser, String txtMsg) {
        for (UserID clientDest : ChatServer.clients.keySet()) {
            try {
                ChatMessage outMessage = ChatMessage.newBuilder()
                        .setFromUser(fromUser)
                        .setTxtMsg(txtMsg).build();
                ChatServer.clients.get(clientDest).onNext(outMessage);
            } catch (Throwable ex) {
                // error calling remote client, remove client name and callback
                System.out.println("Client " + clientDest.getName() + " removed");
                ChatServer.clients.remove(clientDest);
            }
        }
    }
}
