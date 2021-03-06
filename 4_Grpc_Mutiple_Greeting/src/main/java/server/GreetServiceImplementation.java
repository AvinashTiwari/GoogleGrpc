package server;

import com.proto.greet.*;
import io.grpc.stub.StreamObserver;

public class GreetServiceImplementation extends GreetServiceGrpc.GreetServiceImplBase{

    @Override
    public void greet(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {
        Greeting greeting = request.getGreeting();
        String firstName = greeting.getFirstName();

        String result = " Hello " + firstName;

        GreetResponse response = GreetResponse.newBuilder()
                 .setResult(result)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    //    super.greet(request, responseObserver);
    }

    @Override
    public void greetManyTimes(GreetManyTimesRequest request, StreamObserver<GreetManyTimesResponse> responseObserver) {
        String firstName = request.getGreeting().getFirstName();

        for (int i =0; i <10 ; i++){
            String result = "Hello " + firstName + " responseNumber " + i;

            GreetManyTimesResponse response = GreetManyTimesResponse.newBuilder()
                    .setResult(result)
                    .build();

            responseObserver.onNext(response);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        responseObserver.onCompleted();
    }
}
