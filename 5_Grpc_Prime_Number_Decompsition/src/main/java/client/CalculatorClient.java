package client;

import com.proto.calculator.CalculatorServiceGrpc;
import com.proto.calculator.PrimeNumberDecompositionRequest;
import com.proto.calculator.SumRequest;
import com.proto.calculator.SumResponse;
import com.proto.greet.GreetRequest;
import com.proto.greet.GreetResponse;
import com.proto.greet.GreetServiceGrpc;
import com.proto.greet.Greeting;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class CalculatorClient {
    public static void main(String[] args) {
        System.out.println("Hello I am Client.");

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052)
                .usePlaintext()
                .build();

        CalculatorServiceGrpc.CalculatorServiceBlockingStub calculatorServiceBlockingStub = CalculatorServiceGrpc.newBlockingStub(channel);

        Integer number = 567890809;
        calculatorServiceBlockingStub.primeNumberDecomposition(PrimeNumberDecompositionRequest.newBuilder()
                .setNumber(number).build())
                .forEachRemaining(response -> {
                  System.out.println(response.getPimeFactor());
                });


        /*
        SumRequest sumRequest = SumRequest.newBuilder()
                .setFirstNumber(100)
                .setSecondNumber(100).build();

        SumResponse response = calculatorServiceBlockingStub.sum(sumRequest);


        System.out.println("Creating stub");

        System.out.println("Result " + response.getSumResult());
*/
        System.out.println("Shutting down channel");

        channel.shutdown();
    }
}
