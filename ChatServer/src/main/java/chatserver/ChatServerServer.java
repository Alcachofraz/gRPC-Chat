package chatserver;

import chat.*;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;

import java.util.logging.Level;

public class ChatServerServer extends ShareGrpc.ShareImplBase {

    private final ShareGrpc.ShareBlockingStub blockingStubShare;

    public ChatServerServer(ShareGrpc.ShareBlockingStub blockingStubShare) {
        this.blockingStubShare = blockingStubShare;
    }

    @Override
    public void shareMessage(SharedMessage request, StreamObserver<Empty> responseObserver) {
        ChatServer.logger.log(Level.INFO, "SERVER-SERVER: Receiving shared message from source " + request.getOriginServer().getIp() + ":" + request.getOriginServer().getPort());
        if (!(request.getOriginServer().getIp().equals(ChatServer.serverIP) && request.getOriginServer().getPort() == ChatServer.serverPort)) {
            ChatServer.logger.log(Level.INFO, "SERVER-SERVER: Sharing message with local clients...");
            ChatServer.broadcastMessageToClients(request.getFromUser(), request.getTxtMsg());
            ChatServer.logger.log(Level.INFO, "SERVER-SERVER: Sharing message with next server...\n");
            blockingStubShare.shareMessage(request);
        }
        else {
            ChatServer.logger.log(Level.INFO, "SERVER-SERVER: Ignoring shared message...\n");
        }
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }
}
