package edu.miu.aop.aop.controller;

import edu.miu.aop.aop.dto.RequestCategoryDTO;
import edu.miu.aop.aop.entity.Category;
import edu.miu.aop.aop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Author: Kuylim TITH
 * Date: 11/3/2022
 */
@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @PostMapping
    public RequestCategoryDTO createCategory(HttpServletRequest request, @RequestBody RequestCategoryDTO dto) {
        return service.save(request, dto);
    }

    @PutMapping("/{id}")
    public RequestCategoryDTO updateCategory(@PathVariable Long id, @RequestBody RequestCategoryDTO dto) {
        return service.update(id, dto);
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return service.getAllCategory();
    }

    @DeleteMapping("/{id}")
    public Boolean deleteCategory(@PathVariable Long id) {
        return service.deleteCategory(id);
    }
}
