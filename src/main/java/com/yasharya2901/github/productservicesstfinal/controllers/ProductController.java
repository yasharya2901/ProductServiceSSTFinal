package com.yasharya2901.github.productservicesstfinal.controllers;

import com.yasharya2901.github.productservicesstfinal.dtos.ExceptionDTO;
import com.yasharya2901.github.productservicesstfinal.dtos.FakeStoreProductDTO;
import com.yasharya2901.github.productservicesstfinal.models.Product;
import com.yasharya2901.github.productservicesstfinal.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public ResponseEntity getProductById(@PathVariable("id") Long id){
        try{
            ResponseEntity<Product> responseEntity = null;
            Product product = productService.getProductById(id);
            responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
            return responseEntity;
        } catch (RuntimeException exception) {
            ExceptionDTO dto = new ExceptionDTO();
            dto.setMessage("Something went wrong");
            dto.setResolution("Do XYZ");
            ResponseEntity<ExceptionDTO> responseEntity = new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
            return responseEntity;
        }
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
