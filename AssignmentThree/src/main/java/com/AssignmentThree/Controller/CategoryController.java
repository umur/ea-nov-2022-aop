package com.AssignmentThree.Controller;

import com.AssignmentThree.Entities.Categories;
import com.AssignmentThree.Service.Implemintation.CategoriesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("Category")
@RestController
public class CategoryController {

    @Autowired
    CategoriesServiceImpl categoriesService;


    @GetMapping("findall")
    List<Categories> getAll(){
        return categoriesService.getAll();
    }


}
