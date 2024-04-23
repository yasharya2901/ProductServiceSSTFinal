package com.yasharya2901.github.productservicesstfinal.repositories;

import com.yasharya2901.github.productservicesstfinal.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
    Optional<Product> findById(Long id);

    @Override
    Product save(Product product);

    @Override
    List<Product> findAll();
}
