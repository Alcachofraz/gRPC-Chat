package chatserver;

import chat.*;
import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.stub.StreamObserver;

import java.util.logging.Level;

public class ChatServerClient extends ChatGrpc.ChatImplBase {

    private final BroadcastGrpc.BroadcastBlockingStub blockingStubBroadcast;

    public ChatServerClient(BroadcastGrpc.BroadcastBlockingStub blockingStubBroadcast) {
        this.blockingStubBroadcast = blockingStubBroadcast;
    }

    @Override
    public void sendMessage(ChatMessage inMessage, StreamObserver<Empty> responseObserver) {
        ChatServer.logger.log(Level.INFO, "CLIENT/SERVER: Broadcasting to next server...");
        blockingStubBroadcast.broadcastMessage(
                BroadcastMessage.newBuilder()
                        .setFromUser(inMessage.getFromUser())
                        .setTxtMsg(inMessage.getTxtMsg())
                        .setOriginServer(
                                EndPoint.newBuilder()
                                        .setIp(ChatServer.serverIP)
                                        .setPort(ChatServer.serverPort)
                                        .build()
                        ).build()
        );

        ChatServer.broadcastMessageToClients(inMessage.getFromUser(), inMessage.getTxtMsg());
        ChatServer.logger.log(Level.INFO, "CLIENT/SERVER: Broadcasting to local clients...");
        ChatServer.logger.log(Level.INFO, "");

        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();

    }

    @Override
    public void register(UserID clientID, StreamObserver<ChatMessage> responseObserver) {
        ChatServer.logger.log(Level.INFO, "Registering user " + clientID + ".");
        synchronized (ChatServer.clients) {
            if (!ChatServer.clients.containsKey(clientID))
                ChatServer.clients.put(clientID, responseObserver);
            else {
                System.out.println("Client " + clientID.getName() + " already taken");
                Throwable t = new StatusException(
                        Status.INVALID_ARGUMENT.withDescription("Client nickname already taken")
                );
                responseObserver.onError(t);
            }
        }
    }
}
