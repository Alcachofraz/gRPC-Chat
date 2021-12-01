package chatRingManager;

import chat.EndPoint;
import chat.EnrollGrpc;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;

public class ChatRingManagerServer extends EnrollGrpc.EnrollImplBase {

    public static final List<StreamObserver<EndPoint>> servers = new ArrayList<>();

    public ChatRingManagerServer() {}

    @Override
    public void enroll(EndPoint request, StreamObserver<EndPoint> responseObserver) {
        ChatRingManager.ring.add(request);
        ChatRingManager.logger.info("SERVER-RING_MANAGER: " + request.getIp() + ":" + request.getPort() + " has enrolled. Ring: [" + ChatRingManager.ring.size() + "/" + ChatRingManager.ringSize + "]");
        servers.add(responseObserver);
        if (servers.size() == ChatRingManager.ringSize) {
            for (int i = 0; i < ChatRingManager.ringSize; i++) {
                servers.get(i).onNext(ChatRingManager.ring.get((i + 1 == ChatRingManager.ringSize) ? 0 : i + 1));
                servers.get(i).onCompleted();
            }
        }
    }
}
