package com.AssignmentThree.Service.Implemintation;

import com.AssignmentThree.Entities.Addresses;
import com.AssignmentThree.Entities.Categories;
import com.AssignmentThree.Reposotory.CategoriesRepo;
import com.AssignmentThree.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoryService {

    @Autowired
    CategoriesRepo categoriesRepo;

    @Override
    public void delete(Integer categoryID) {
        categoriesRepo.deleteById(categoryID);
    }

    @Override
    public void add(Categories category) {
        categoriesRepo.save(category);
    }

    @Override
    public List<Categories> getAll() {
        return categoriesRepo.findAll();
    }

    @Override
    public Categories getCategoriesByName(String catName) {
        return categoriesRepo.getCategoriesByName(catName);
    }

}
