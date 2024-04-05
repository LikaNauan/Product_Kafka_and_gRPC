package com.aston.consumer.handler;

import com.aston.consumer.entity.CompanyEntity;
import com.aston.consumer.repository.CompanyRepository;
import com.aston.core.ProductCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProductCreatedEventHandler {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private final CompanyRepository companyRepository;

    @KafkaListener(groupId = "product-created-events", topics = "product-create-topic")
    public void handle(ConsumerRecord<String, ProductCreatedEvent> record) {
        LOGGER.info("A NEW PRODUCT HAS BEEN ADDED TO THE COMPANY: A SPOON: {}", record.value().getTitle());
        CompanyEntity companyEntity = CompanyEntity.builder()
                .company(record.value().getCompany())
                .productId(UUID.fromString(record.key()))
                .build();
        companyRepository.save(companyEntity);
    }
}
