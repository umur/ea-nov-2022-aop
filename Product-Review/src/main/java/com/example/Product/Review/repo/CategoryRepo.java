package com.example.Product.Review.repo;

import com.example.Product.Review.entities.join_column.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long> {
}
