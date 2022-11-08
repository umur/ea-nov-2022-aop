package com.example.lab3.repository;

import com.example.lab3.entity.bidirectional.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<Category, Long> {
    Category findByNameIs(String name);
}
