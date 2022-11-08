package com.example.eanov2022aop.repository;

import com.example.eanov2022aop.entity.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends CrudRepository<Category,Integer> {
    @Query("SELECT c FROM Category c WHERE c.id = ?1")
    Category findCategoryById(Integer id);
}
