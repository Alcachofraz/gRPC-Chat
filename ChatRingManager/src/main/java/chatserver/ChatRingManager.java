package chatserver;

import chat.EndPoint;
import io.grpc.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ChatRingManager {

    public static final Logger logger = Logger.getLogger(ChatRingManager.class.getName());
    static int serverPort = 9000;
    public static final int RING_SIZE = 3;

    public static List<EndPoint> ring = new ArrayList<>();

    public static void main(String[] args) {
        try {
            if (args.length == 1) serverPort = Integer.parseInt(args[0]);

            final Server svc = ServerBuilder.forPort(serverPort)
                    .addService(new ChatRingManagerServer())
                    .addService(new ChatRingManagerClient())
                    .build()
                    .start();

            logger.info("Server started, listening on " + serverPort + "...");

            System.err.println("*** Server awaiting termination...");

            svc.awaitTermination();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
