package chatRingManager;

import chat.EndPoint;
import io.grpc.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

public class ChatRingManager {

    public static final Logger logger = Logger.getLogger(ChatRingManager.class.getName());
    static int serverPort = 9000;
    public static int ringSize = 3;

    public static List<EndPoint> ring = new ArrayList<>();

    public static void main(String[] args) {
        HashMap<String, String> keyValueArgs = convertToKeyValuePair(args);
        String endpoint;
        String size;
        if ((endpoint = keyValueArgs.get("endpoint")) != null) {
            serverPort = Integer.parseInt(endpoint.substring(endpoint.indexOf(":") + 1));
        }
        if ((size = keyValueArgs.get("ring-size")) != null) {
            ringSize = Integer.parseInt(size);
        }

        try {
            final Server svc = ServerBuilder.forPort(serverPort)
                    .addService(new ChatRingManagerServer())
                    .addService(new ChatRingManagerClient())
                    .build()
                    .start();

            logger.info("RING_MANAGER: Server started, listening on " + serverPort + "...\n");

            System.err.println("*** Server awaiting termination... ***\n");

            svc.awaitTermination();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static HashMap<String, String> convertToKeyValuePair(String[] args) {
        HashMap<String, String> params = new HashMap<>();

        for (String arg: args) {
            String[] splitFromEqual = arg.split("=");

            String key = splitFromEqual[0].substring(2);
            String value = splitFromEqual[1];

            params.put(key, value);
        }
        return params;
    }
}
