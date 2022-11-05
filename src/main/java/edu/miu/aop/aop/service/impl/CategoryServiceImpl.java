package edu.miu.aop.aop.service.impl;

import edu.miu.aop.aop.aspect.annotation.ExecutionTime;
import edu.miu.aop.aop.aspect.annotation.ValidatePostMethod;
import edu.miu.aop.aop.dto.RequestCategoryDTO;
import edu.miu.aop.aop.entity.Category;
import edu.miu.aop.aop.repository.CategoryRepository;
import edu.miu.aop.aop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

/**
 * Author: Kuylim TITH
 * Date: 11/3/2022
 */
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    @Override
    @ExecutionTime
    @ValidatePostMethod
    public RequestCategoryDTO save(HttpServletRequest request, RequestCategoryDTO category) {
        Category cat = new Category();
        BeanUtils.copyProperties(category, cat, "id");
        repository.save(cat);
        return category;
    }

    @Override
    @ExecutionTime
    public RequestCategoryDTO update(Long id, RequestCategoryDTO category) {
        Optional<Category> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new RuntimeException("Category not found!");
        }
        Category cat = optional.get();
        BeanUtils.copyProperties(category, cat, "id");
        repository.save(cat);
        return category;
    }

    @Override
    @ExecutionTime
    public List<Category> getAllCategory() {
        return repository.findAll();
    }

    @Override
    @ExecutionTime
    public Boolean deleteCategory(Long id) {
        repository.deleteById(id);
        return true;
    }
}
