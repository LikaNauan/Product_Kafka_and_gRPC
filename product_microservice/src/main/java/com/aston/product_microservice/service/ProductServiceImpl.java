package com.aston.product_microservice.service;

import com.aston.core.ProductCreatedEvent;
import com.aston.grpc.Event;
import com.aston.grpc.EventServiceGrpc;
import com.aston.product_microservice.dto.ProductDto;
import com.aston.product_microservice.entity.ProductEntity;
import com.aston.product_microservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    @Autowired
    private KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;
    @Autowired
    private ProductRepository productRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public String createProduct(ProductDto productDto) throws ExecutionException, InterruptedException {

        BigDecimal newPrice = newPrice(productDto.getPrice(), "Запрос на новую цену.");

        ProductEntity productEntity = ProductEntity.builder()
                .title(productDto.getTitle())
                .price(newPrice)
                .quantity(productDto.getQuantity())
                .build();
        productRepository.save(productEntity);
        LOGGER.info("Product {} saved", productEntity.getProductId());

        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent(productDto.getTitle(), "Aston");
        SendResult<String, ProductCreatedEvent> result = kafkaTemplate
                .send("product-create-topic", productEntity.getProductId().toString(), productCreatedEvent).get();
        LOGGER.info("Topic: {}", result.getRecordMetadata().topic());

        return  "The price has been changed by " + productEntity.getPrice().toString();
    }

    @GrpcClient("service-grpc")
    EventServiceGrpc.EventServiceBlockingStub stub;

    BigDecimal newPrice(BigDecimal price, String message) {
        Event.CreatedEventRequest request = Event.CreatedEventRequest.newBuilder()
                .setMessage(message).build();

        Event.CreatedEventResponse response = stub.createdEvent(request);
        BigDecimal newPrice = price.multiply(BigDecimal.valueOf(response.getUpPrice()));
        LOGGER.info("The price has been changed by " + response.getCompany() + ". new price: " + newPrice);
        return newPrice;
    }
}
