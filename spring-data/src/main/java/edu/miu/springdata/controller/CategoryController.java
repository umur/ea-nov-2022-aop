package edu.miu.springdata.controller;

import edu.miu.springdata.aspect.annotation.ExecutionTime;
import edu.miu.springdata.entity.Category;
import edu.miu.springdata.entity.Product;
import edu.miu.springdata.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/springdata/category")
public class CategoryController {

    private final CategoryService categoryService;

    @ExecutionTime
    @PostMapping
    public String create(@RequestBody Category category) {
        try {
            categoryService.save(category);

            return "Category saved successfully.";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while saving Category.";
        }
    }

    @ExecutionTime
    @PutMapping
    public String update(@RequestBody Category category) {
        try {
            categoryService.save(category);

            return "Category updated successfully.";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while updating Category.";
        }
    }

    @ExecutionTime
    @DeleteMapping("/{categoryId}")
    public String delete(@PathVariable Long categoryId) {
        try {
            categoryService.delete(categoryId);

            return "Category deleted successfully.";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while deleting Category.";
        }
    }

    @ExecutionTime
    @GetMapping
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @ExecutionTime
    @GetMapping("/{categoryId}")
    public Category getById(@PathVariable Long categoryId) {
        return categoryService.getById(categoryId);
    }

    @ExecutionTime
    @GetMapping("/filterProductByCategoryAndPriceLessThanMaxPrice")
    public List<Product> filterProductByCategoryAndPriceLessThanMaxPrice(@RequestBody Category cat, @RequestParam double maxPrice) {
        return categoryService.findAllByCategoryAndPriceLessThan(cat, maxPrice);
    }

}
