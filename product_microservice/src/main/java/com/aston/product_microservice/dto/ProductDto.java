package com.aston.product_microservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String title;
    private BigDecimal price;
    private Integer quantity;
}
