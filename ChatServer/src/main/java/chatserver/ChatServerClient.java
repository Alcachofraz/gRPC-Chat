package chatserver;

import chat.*;
import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.stub.StreamObserver;

import java.util.logging.Level;

public class ChatServerClient extends ChatGrpc.ChatImplBase {

    private final ShareGrpc.ShareBlockingStub blockingStubShare;

    public ChatServerClient(ShareGrpc.ShareBlockingStub blockingStubShare) {
        this.blockingStubShare = blockingStubShare;
    }

    @Override
    public void sendMessage(ChatMessage inMessage, StreamObserver<Empty> responseObserver) {
        ChatServer.broadcastMessageToClients(inMessage.getFromUser(), inMessage.getTxtMsg());
        ChatServer.logger.log(Level.INFO, "CLIENT-SERVER: Sharing message with local clients...");

        ChatServer.logger.log(Level.INFO, "CLIENT-SERVER: Sharing message with next server...\n");
        blockingStubShare.shareMessage(
                SharedMessage.newBuilder()
                        .setFromUser(inMessage.getFromUser())
                        .setTxtMsg(inMessage.getTxtMsg())
                        .setOriginServer(
                                EndPoint.newBuilder()
                                        .setIp(ChatServer.serverIP)
                                        .setPort(ChatServer.serverPort)
                                        .build()
                        ).build()
        );

        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();

    }

    @Override
    public void register(UserID clientID, StreamObserver<ChatMessage> responseObserver) {
        ChatServer.logger.log(Level.INFO, "Registering user " + clientID);
        synchronized (ChatServer.clients) {
            if (!ChatServer.clients.containsKey(clientID))
                ChatServer.clients.put(clientID, responseObserver);
            else {
                System.out.println("Client " + clientID.getName() + " already taken\n");
                Throwable t = new StatusException(
                        Status.INVALID_ARGUMENT.withDescription("Client nickname already taken")
                );
                responseObserver.onError(t);
            }
        }
    }
}
