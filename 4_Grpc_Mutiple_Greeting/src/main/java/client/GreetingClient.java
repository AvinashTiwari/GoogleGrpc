package client;

import com.proto.dummy.DummyServiceGrpc;
import com.proto.greet.GreetRequest;
import com.proto.greet.GreetResponse;
import com.proto.greet.GreetServiceGrpc;
import com.proto.greet.Greeting;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GreetingClient {

    public static void main(String[] args) {
        System.out.println("Hello I am Client.");

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        System.out.println("Creating stub");

        GreetServiceGrpc.GreetServiceBlockingStub greetClient = GreetServiceGrpc.newBlockingStub(channel);
        Greeting greeting = Greeting.newBuilder()
                .setFirstName("Avinash")
                .setLastName("Tiwari")
                .build();

        GreetRequest greetequest = GreetRequest.newBuilder()
                .setGreeting(greeting)
                .build();

     GreetResponse response = greetClient.greet(greetequest);
        System.out.println("Result " + response.getResult());

        System.out.println("Shutting down channel");

        channel.shutdown();

    }
}
