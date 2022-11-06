package com.AssignmentThree.Service;

import com.AssignmentThree.Entities.Categories;

import java.util.List;

public interface CategoryService {

    void add(Categories category);

    void delete(Integer categoryId);

    //    void update()

    List<Categories> getAll();
    Categories getCategoriesByName(String catName);
}
