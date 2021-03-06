package server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GreetingServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hello Grpc");

        Server server = ServerBuilder.forPort(8085)
                .addService(new GreetServiceImplementation())
                .build();
        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Received shutting down request");

            server.shutdown();

            System.out.println("Serve Shutdown");



        }));

        server.awaitTermination();

    }
}
