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

    @Override
    public StreamObserver<LongGreetRequest> longGreet(StreamObserver<LongGreetResponse> responseObserver) {
        // we create the requestObserver that we'll return in this function
        StreamObserver<LongGreetRequest> requestObserver = new StreamObserver<LongGreetRequest>() {

            String result = "";

            @Override
            public void onNext(LongGreetRequest value) {
                // client sends a message
                result += "Hello " + value.getGreeting().getFirstName() + "! ";
            }

            @Override
            public void onError(Throwable t) {
                // client sends an error
            }

            @Override
            public void onCompleted() {
                // client is done
                responseObserver.onNext(
                        LongGreetResponse.newBuilder()
                                .setResult(result)
                                .build()
                );
                responseObserver.onCompleted();
            }
        };


        return requestObserver;
    }
}
