package com.aston.product_microservice.service;

import com.aston.product_microservice.dto.ProductDto;

import java.util.concurrent.ExecutionException;

public interface ProductService {
    String createProduct(ProductDto productDto) throws ExecutionException, InterruptedException;
}
