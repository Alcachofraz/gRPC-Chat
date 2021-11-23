package chatserver;

import chat.*;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;

import java.util.logging.Level;

public class ChatServerServer extends BroadcastGrpc.BroadcastImplBase {

    private final BroadcastGrpc.BroadcastBlockingStub blockingStubBroadcast;

    public ChatServerServer(BroadcastGrpc.BroadcastBlockingStub blockingStubBroadcast) {
        this.blockingStubBroadcast = blockingStubBroadcast;
    }

    @Override
    public void broadcastMessage(BroadcastMessage request, StreamObserver<Empty> responseObserver) {
        ChatServer.logger.log(Level.INFO, "SERVER/SERVER: Received broadcast from source " + request.getOriginServer().getIp() + ":" + request.getOriginServer().getPort());
        if (!(request.getOriginServer().getIp().equals(ChatServer.serverIP) && request.getOriginServer().getPort() == ChatServer.serverPort)) {
            ChatServer.logger.log(Level.INFO, "SERVER/SERVER: Broadcasting to next server...");
            blockingStubBroadcast.broadcastMessage(request);
            ChatServer.logger.log(Level.INFO, "SERVER/SERVER: Broadcasting to local clients...");
            ChatServer.broadcastMessageToClients(request.getFromUser(), request.getTxtMsg());
        }
        else {
            ChatServer.logger.log(Level.INFO, "SERVER/SERVER: Broadcast ignored");
        }
        ChatServer.logger.log(Level.INFO, "");
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }
}
