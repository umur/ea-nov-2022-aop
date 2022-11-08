package miu.edu.ea_day3_crudwithdb.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.ea_day3_crudwithdb.DTO.CategoryDto;
import miu.edu.ea_day3_crudwithdb.DTO.ProductDto;
import miu.edu.ea_day3_crudwithdb.annotation.ExecutionTime;
import miu.edu.ea_day3_crudwithdb.entity.Category;
import miu.edu.ea_day3_crudwithdb.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public void save(@RequestBody CategoryDto c) {
        categoryService.save(c);
    }

    @GetMapping
    @ExecutionTime
    public List<CategoryDto> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("getProductByCategoryAndPriceLessThanMax")
    public List<ProductDto> getProductByCategoryAndPriceLessThanMax(
            @RequestParam String category, @RequestParam double maxPrice) {
        return categoryService.getProductsByCategoryAndCostLessThanMaxPrice(category, maxPrice);
    }

    @GetMapping("/{id}")
    @ExecutionTime
    public ResponseEntity<CategoryDto> getById(@PathVariable int id) {
        var category = categoryService.getById(id);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        categoryService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int categoryId, @RequestBody CategoryDto category) {
        categoryService.update(categoryId, category);
    }

}
