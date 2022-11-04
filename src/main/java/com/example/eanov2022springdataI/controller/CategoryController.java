package com.example.eanov2022springdataI.controller;


import com.example.eanov2022springdataI.entity.Category;
import com.example.eanov2022springdataI.service.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController extends CrudController<Category, CategoryService>{
    public CategoryController(CategoryService service) {
        super(service);
    }
}
