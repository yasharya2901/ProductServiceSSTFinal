package com.yasharya2901.github.productservicesstfinal.services;

import com.yasharya2901.github.productservicesstfinal.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    List<Product> getAllProducts();
    Product createProduct(Product product);

}
