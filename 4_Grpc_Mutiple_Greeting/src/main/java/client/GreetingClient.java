package client;

import com.proto.dummy.DummyServiceGrpc;
import com.proto.greet.*;
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

        /*
        Greeting greeting = Greeting.newBuilder()
                .setFirstName("Avinash")
                .setLastName("Tiwari")
                .build();

        GreetRequest greetequest = GreetRequest.newBuilder()
                .setGreeting(greeting)
                .build();

     GreetResponse response = greetClient.greet(greetequest);
        System.out.println("Result " + response.getResult());
*/
        GreetManyTimesRequest request = GreetManyTimesRequest.newBuilder()
                                        .setGreeting(Greeting.newBuilder().setFirstName("Avinash"))
                .build();
        greetClient.greetManyTimes(request)
        .forEachRemaining(response -> {
            System.out.println(response.getResult());
        });
        System.out.println("Shutting down channel");

        channel.shutdown();

    }
}
