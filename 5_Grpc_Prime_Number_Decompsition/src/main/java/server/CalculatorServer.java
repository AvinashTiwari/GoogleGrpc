package server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class CalculatorServer {

    public static void main(String[] args) throws InterruptedException, IOException {
        Server server = ServerBuilder.forPort(50052)
                .addService(new CalculatoServiceImpl())
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
