package com.yasharya2901.github.productservicesstfinal.controllers;

import com.yasharya2901.github.productservicesstfinal.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductControllerTest {
    // What to test?
    // Happy Test Case
    // Negative Test Case
    // Edge Test Case


    @Autowired // Dependency Injection // Field Injection
    private ProductController productController;

    @Test
    void testValidProductId() {
        Product product = productController.getProductById(1L);
    }

    @Test
    void testInvalidProductId() {

    }

    @Test
    void getAllProducts() {
    }

    @Test
    void createProduct() {
    }
}