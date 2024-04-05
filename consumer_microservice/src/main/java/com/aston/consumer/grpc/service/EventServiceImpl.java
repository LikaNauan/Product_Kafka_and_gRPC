package com.aston.consumer.grpc.service;

import com.aston.grpc.CreatedEventRequest;
import com.aston.grpc.CreatedEventResponse;
import com.aston.grpc.Event;
import com.aston.grpc.EventServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@GRpcService
public class EventServiceImpl extends EventServiceGrpc.EventServiceImplBase {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public void createdEvent (CreatedEventRequest request, StreamObserver<CreatedEventResponse> responseObserver){
        LOGGER.info("My log: gRPC createdEvent. message: {}", request.getMessage());

        CreatedEventResponse response = CreatedEventResponse.newBuilder()
                .setUpPrice(10)
                .setCompany("Aston")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
