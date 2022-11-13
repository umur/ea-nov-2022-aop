package com.example.EA.Lab3.Controller;

import com.example.EA.Lab3.DTO.CategoryDTO;
import com.example.EA.Lab3.Entity.Category;
import com.example.EA.Lab3.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDTO> findAll(){
        return categoryService.findAll();
    }
    @PostMapping
    public CategoryDTO save(@RequestBody CategoryDTO category){return categoryService.save(category);}
    @PutMapping
    public CategoryDTO update(@PathVariable Long id, @RequestBody CategoryDTO category){
        return categoryService.update(id, category);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        categoryService.delete(id);
    }
}
