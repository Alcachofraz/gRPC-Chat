package chatRingManager;

import chat.EndPoint;
import chat.ServerProviderGrpc;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;

public class ChatRingManagerClient extends ServerProviderGrpc.ServerProviderImplBase {
    /**
     * Round Robin server distribution index.
     */
    private int rrServer;

    public ChatRingManagerClient() {
        rrServer = 0;
    }

    @Override
    public void requestServer(Empty request, StreamObserver<EndPoint> responseObserver) {
        ChatRingManager.logger.info("CLIENT-RING_MANAGER: Got server request. Returning " + ChatRingManager.ring.get(rrServer).getIp() + ":" + ChatRingManager.ring.get(rrServer).getPort());
        responseObserver.onNext(ChatRingManager.ring.get(rrServer));
        responseObserver.onCompleted();
        // Increment Round Robin index:
        rrServer = (rrServer + 1 == ChatRingManager.ringSize) ? 0 : rrServer + 1;
    }
}
