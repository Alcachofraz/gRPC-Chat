package chatserver;

import chat.*;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;

import java.util.logging.Level;

public class ChatServerServer extends BroadcastGrpc.BroadcastImplBase {

    private final BroadcastGrpc.BroadcastStub nonBlockingStubBroadcast;

    public ChatServerServer(BroadcastGrpc.BroadcastStub nonBlockingStubBroadcast) {
        this.nonBlockingStubBroadcast = nonBlockingStubBroadcast;
    }

    @Override
    public void broadcastMessage(BroadcastMessage request, StreamObserver<Empty> responseObserver) {
        ChatServer.logger.log(Level.INFO, "Received broadcast.");
        if (!(request.getOriginServer().getIp().equals(ChatServer.serverIP) && request.getOriginServer().getPort() == ChatServer.serverPort)) {
            nonBlockingStubBroadcast.broadcastMessage(request, new ServerBroadcastObserver());
            ChatServer.broadcastMessageToClients(request.getFromUser(), request.getTxtMsg());
        }
    }
}
