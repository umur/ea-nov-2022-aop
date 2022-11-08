package com.example.productreview.repository;

import com.example.productreview.entity.uni_and_bi_directional.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepo extends CrudRepository<Category, Long> {
    List<Category> findAll();
}
