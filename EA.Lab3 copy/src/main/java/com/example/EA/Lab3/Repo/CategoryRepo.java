package com.example.EA.Lab3.Repo;

import com.example.EA.Lab3.Entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long> {
}
