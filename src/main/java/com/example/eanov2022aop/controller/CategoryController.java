package com.example.eanov2022aop.controller;


import com.example.eanov2022aop.aspect.annotation.ExecutionTime;
import com.example.eanov2022aop.dto.CategoryDto;
import com.example.eanov2022aop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    @ExecutionTime
    public List <CategoryDto> getCategories(){
        return categoryService.findAll ();
    }

    @GetMapping(path = "/{id}")
    public CategoryDto getCategoryById(@PathVariable("id") Integer id){
        return categoryService.findCategoryById (id);

    }

    @PostMapping
    public void create(@RequestBody CategoryDto categoryDto){
        categoryService.create (categoryDto);
    }

    @PutMapping(path = "/{id}")
    public void update(@PathVariable("id") Integer id,
                       @RequestParam(required = false) String name){
        categoryService.update (id,name);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") Integer id){
        categoryService.delete(id);

    }
}
