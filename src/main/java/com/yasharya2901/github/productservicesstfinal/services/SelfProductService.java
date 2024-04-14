package com.yasharya2901.github.productservicesstfinal.services;

import com.yasharya2901.github.productservicesstfinal.exceptions.ProductNotFoundException;
import com.yasharya2901.github.productservicesstfinal.models.Product;
import com.yasharya2901.github.productservicesstfinal.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SelfProductService implements ProductService{
    private ProductRepository productRepository;
    SelfProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException(id, "Product not found");
        }
        return optionalProduct.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
