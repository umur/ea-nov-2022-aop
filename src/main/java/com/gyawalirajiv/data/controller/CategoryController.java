package com.gyawalirajiv.data.controller;

import com.gyawalirajiv.data.models.DTOs.CategoryDTO;
import com.gyawalirajiv.data.models.DTOs.ProductDTO;
import com.gyawalirajiv.data.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public CategoryDTO save(@RequestBody CategoryDTO categoryDTO){
        return categoryService.save(categoryDTO);
    }

    @GetMapping
    public List<CategoryDTO> findAll(){
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public CategoryDTO find(@PathVariable Long id){
        return categoryService.find(id);
    }

    @GetMapping("/{name}")
    public List<ProductDTO> findAllProductsWithCategoryAndMaxPrice(@PathVariable String name, @RequestParam Integer maxPrice){
        return categoryService.findAllProductsWithCategoryAndMaxPrice(name, maxPrice);
    }

    @PutMapping("/{id}")
    public CategoryDTO update(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO){
        return categoryService.update(id, categoryDTO);
    }

    @DeleteMapping("/{id}")
    public CategoryDTO delete(@PathVariable Long id){
        return categoryService.delete(id);
    }

}
