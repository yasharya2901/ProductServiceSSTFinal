package com.yasharya2901.github.productservicesstfinal.services;

import com.yasharya2901.github.productservicesstfinal.exceptions.CategoryNotFoundException;
import com.yasharya2901.github.productservicesstfinal.exceptions.ProductNotFoundException;
import com.yasharya2901.github.productservicesstfinal.exceptions.ProductsNotFoundException;
import com.yasharya2901.github.productservicesstfinal.models.Category;
import com.yasharya2901.github.productservicesstfinal.models.Product;
import com.yasharya2901.github.productservicesstfinal.repositories.CategoryRepository;
import com.yasharya2901.github.productservicesstfinal.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("SelfProductService")
@Primary // This will tell the spring if there are more than two class marked as service, this should be the primary one.
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
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()){
            throw new ProductsNotFoundException("No products found");
        }
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();
        if (category.getId() == null) { // save the category to the database
            product.setCategory(categoryRepository.save(category));
        }
        Optional<Category> optionalCategory = categoryRepository.findById(category.getId());
        if (optionalCategory.isEmpty()){
            // throw an exception
            throw new CategoryNotFoundException(category.getId(),"Invalid Category Id was passed.");
        }
        Product saved_product = productRepository.save(product);
        saved_product.setCategory(optionalCategory.get());
        return saved_product;
    }
}
