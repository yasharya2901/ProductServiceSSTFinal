package com.yasharya2901.github.productservicesstfinal.repositories;

import com.yasharya2901.github.productservicesstfinal.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Override
    Category save(Category category);
}
