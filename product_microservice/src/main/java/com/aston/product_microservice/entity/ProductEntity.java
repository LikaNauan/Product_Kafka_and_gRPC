package com.aston.product_microservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductEntity {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "product_id")
    private UUID productId;
    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "quantity")
    private Integer quantity;
}
