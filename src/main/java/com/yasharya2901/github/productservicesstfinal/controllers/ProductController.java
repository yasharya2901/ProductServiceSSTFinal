package com.yasharya2901.github.productservicesstfinal.controllers;

import com.yasharya2901.github.productservicesstfinal.dtos.FakeStoreProductDTO;
import com.yasharya2901.github.productservicesstfinal.models.Product;
import com.yasharya2901.github.productservicesstfinal.services.FakeStoreProductService;
import com.yasharya2901.github.productservicesstfinal.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// This controller is capable to host HTTP API
@RestController
// localhost:8080/products -> ProductController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }
    // localhost:8080/products/10
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    
}
