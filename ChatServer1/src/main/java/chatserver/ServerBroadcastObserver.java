package chatserver;

import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;

/**
 * Dummy observer.
 */
public class ServerBroadcastObserver implements StreamObserver<Empty> {
    @Override
    public void onNext(Empty empty) {

    }

    @Override
    public void onError(Throwable throwable) {
        // Empty
    }

    @Override
    public void onCompleted() {
        // Empty
    }
}
