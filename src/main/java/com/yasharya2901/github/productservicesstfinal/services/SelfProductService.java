package com.yasharya2901.github.productservicesstfinal.services;

import com.yasharya2901.github.productservicesstfinal.exceptions.ProductNotFoundException;
import com.yasharya2901.github.productservicesstfinal.models.Category;
import com.yasharya2901.github.productservicesstfinal.models.Product;
import com.yasharya2901.github.productservicesstfinal.repositories.CategoryRepository;
import com.yasharya2901.github.productservicesstfinal.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("SelfProductService")
//@Primary // This will tell the spring if there are more than two class marked as service, this should be the primary one.
public class SelfProductService implements ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
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
        Category category = product.getCategory();
        if (category.getId() == null) { // save the category to the database
            product.setCategory(categoryRepository.save(category));
        }
        return productRepository.save(product);
    }
}
