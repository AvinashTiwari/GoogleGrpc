package client;

import com.proto.greet.*;
import io.grpc.*;
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.net.ssl.SSLException;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class GreetingClient {
    public static void main(String[] args)  {
        System.out.println("Hello I'm a gRPC client");

        GreetingClient main = new GreetingClient();
        main.run();
    }

    private void run()  {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();


        // With server authentication SSL/TLS; custom CA root certificates; not on Android
//        ManagedChannel secureChannel = NettyChannelBuilder.forAddress("localhost", 50051)
//                .sslContext(GrpcSslContexts.forClient().trustManager(new File("ssl/ca.crt")).build())
//                .build();

       // doUnaryCall(channel);

        //doServerStreamingCall(channel);

        doClientStreamingCall(channel);

        System.out.println("Shutting down channel");
        channel.shutdown();

    }



    private void doClientStreamingCall(ManagedChannel channel) {
        // create an asynchronous client
        GreetServiceGrpc.GreetServiceStub asyncClient = GreetServiceGrpc.newStub(channel);

        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<LongGreetRequest> requestObserver = asyncClient.longGreet(new StreamObserver<LongGreetResponse>() {
            @Override
            public void onNext(LongGreetResponse value) {
                // we get a response from the server
                System.out.println("Received a response from the server");
                System.out.println(value.getResult());
                // onNext will be called only once
            }

            @Override
            public void onError(Throwable t) {
                // we get an error from the server
                System.out.println("Error Ocurred");
            }

            @Override
            public void onCompleted() {
                // the server is done sending us data
                // onCompleted will be called right after onNext()
                System.out.println("Server has completed sending us something");
                latch.countDown();
            }
        });

        // streaming message #1
        System.out.println("sending message 1");
        requestObserver.onNext(LongGreetRequest.newBuilder()
                .setGreeting(Greeting.newBuilder()
                        .setFirstName("Avinash")
                        .build())
                .build());

        // streaming message #2
        System.out.println("sending message 2");
        requestObserver.onNext(LongGreetRequest.newBuilder()
                .setGreeting(Greeting.newBuilder()
                        .setFirstName("Avinash Tiwari")
                        .build())
                .build());

        // streaming message #3
        System.out.println("sending message 3");
        requestObserver.onNext(LongGreetRequest.newBuilder()
                .setGreeting(Greeting.newBuilder()
                        .setFirstName("Avinash 1")
                        .build())
                .build());

        // we tell the server that the client is done sending data
        requestObserver.onCompleted();

        try {
            latch.await(3L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
