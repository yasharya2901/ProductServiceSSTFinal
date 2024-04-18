package com.yasharya2901.github.productservicesstfinal.controllers;

import com.yasharya2901.github.productservicesstfinal.models.Product;
import com.yasharya2901.github.productservicesstfinal.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {
    // What to test?
    // Happy Test Case
    // Negative Test Case
    // Edge Test Case


    @Autowired // Dependency Injection // Field Injection
    private ProductController productController;
    @MockBean
    private ProductService productService;


    @Test
    void testValidProductId() {
        // Mock the ProductService
        Product product = new Product();
        product.setId(1L);
        product.setTitle("iPhone 15");
        product.setPrice(1500.0);
        when(productService.getProductById(1L)).thenReturn(product);

        Product outProduct = productController.getProductById(1L);
        assertEquals(product, outProduct);
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