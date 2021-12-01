package chatClient;

import chat.*;
import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatClient {

    public static final Logger logger = Logger.getLogger(ChatClient.class.getName());

    public static String ringManagerIP = "localhost";
    public static int ringManagerPort = 9000;

    public static void main(String[] args) throws Exception {
        ManagedChannel channelProvider = null;
        ManagedChannel channelChat = null;

        HashMap<String, String> keyValueArgs = convertToKeyValuePair(args);
        String endpointRingManager;
        if ((endpointRingManager = keyValueArgs.get("endpoint-ring-manager")) != null) {
            ringManagerIP = endpointRingManager.substring(0, endpointRingManager.indexOf(":"));
            ringManagerPort = Integer.parseInt(endpointRingManager.substring(endpointRingManager.indexOf(":") + 1));
        }

        try {
            System.out.println("Awaiting server endpoint...");

            // Setup Channel to RingManager
            channelProvider = ManagedChannelBuilder.forAddress(ringManagerIP, ringManagerPort)
                    // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                    // needing certificates.
                    .usePlaintext()
                    .build();
            ServerProviderGrpc.ServerProviderBlockingStub blockingStubProvider = ServerProviderGrpc.newBlockingStub(channelProvider);

            EndPoint server = blockingStubProvider.requestServer(Empty.newBuilder().build());

            System.out.println("Got server endpoint");

            if (channelProvider != null) {
                logger.log(Level.INFO, "Shutdown channel to RingManager.");
                channelProvider.shutdown().awaitTermination(5, TimeUnit.SECONDS);
            }

            Scanner input = new Scanner(System.in);
            System.out.println("Enter your nickName: ");
            String clientName = input.nextLine();

            // Setup Channel to Server
            channelChat = ManagedChannelBuilder.forAddress(server.getIp(), server.getPort())
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build();
            ChatGrpc.ChatStub nonBlockingStubChat = ChatGrpc.newStub(channelChat);
            ChatGrpc.ChatBlockingStub blockingStubChat = ChatGrpc.newBlockingStub(channelChat);

            // register client in remote server
            nonBlockingStubChat.register(UserID.newBuilder().setName(clientName).build(), new ClientChatObserver());
            // send messages
            System.out.println("Enter lines or the word \"exit\"");
            while (true) {
                String line = input.nextLine(); if (line.equals("exit")) break;
                blockingStubChat.sendMessage(ChatMessage.newBuilder()
                    .setFromUser(clientName)
                    .setTxtMsg(line).build());
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Error:" + ex.getMessage());
        }
        if (channelChat != null) {
            logger.log(Level.INFO, "Shutdown channel to Server.");
            channelChat.shutdown().awaitTermination(5, TimeUnit.SECONDS);
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
