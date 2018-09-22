package client;

import com.proto.dummy.DummyServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GreetingClient {

    public static void main(String[] args) {
        System.out.println("Hello I am Client.");

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        System.out.println("Creating stub");

        DummyServiceGrpc.DummyServiceBlockingStub syncCliet =   DummyServiceGrpc.newBlockingStub(channel);

       // DummyServiceGrpc.DummyServiceFutureStub asyncClient =DummyServiceGrpc.newFutureStub(channel);

        System.out.println("Shutting down channel");

        channel.shutdown();

    }
}
