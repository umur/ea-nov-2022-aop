package com.AssignmentThree.Reposotory;

import com.AssignmentThree.Entities.Categories;
import jdk.jfr.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoriesRepo extends CrudRepository<Categories , Integer> {

    List<Categories> findAll();

    Categories save(Categories category);
    void deleteById(Integer CategoryId);
    Categories getCategoriesByName(String catName);

}
