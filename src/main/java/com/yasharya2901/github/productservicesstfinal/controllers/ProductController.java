package com.yasharya2901.github.productservicesstfinal.controllers;

import com.yasharya2901.github.productservicesstfinal.dtos.ExceptionDTO;
import com.yasharya2901.github.productservicesstfinal.dtos.FakeStoreProductDTO;
import com.yasharya2901.github.productservicesstfinal.models.Product;
import com.yasharya2901.github.productservicesstfinal.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// This controller is capable to host HTTP API
@RestController
// localhost:8080/products -> ProductController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    ProductController(@Qualifier("SelfProductService") ProductService productService) {
        this.productService = productService;
    }
    // localhost:8080/products/10
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }
}
