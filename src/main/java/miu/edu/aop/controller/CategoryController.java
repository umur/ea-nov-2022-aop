package miu.edu.aop.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.aop.annotation.ExecutionTime;
import miu.edu.aop.dto.CategoryDTO;
import miu.edu.aop.service.CategoryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryServiceImpl service;

    @GetMapping()
    @ExecutionTime
    public List<CategoryDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> get(@PathVariable Long id) {
        return service.findOne(id).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public CategoryDTO create(@RequestBody CategoryDTO category) {
        return service.save(category);
    }

    @PutMapping("/{id}")
    public CategoryDTO update(@PathVariable Long id, @RequestBody CategoryDTO category) {
        category.setId(id);
        return service.save(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}