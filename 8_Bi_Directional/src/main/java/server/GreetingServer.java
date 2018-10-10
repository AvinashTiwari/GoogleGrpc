package server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GreetingServer {

    public static void main(String[] args)  {
        System.out.println("Hello Grpc");

        Server server = ServerBuilder.forPort(50051)
                .addService(new GreetServiceImplementation())
                .build();
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Received shutting down request");

            server.shutdown();

            System.out.println("Serve Shutdown");



        }));

        try {
            server.awaitTermination();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
