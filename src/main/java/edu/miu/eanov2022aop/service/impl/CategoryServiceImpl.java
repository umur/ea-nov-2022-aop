package edu.miu.eanov2022aop.service.impl;

import edu.miu.eanov2022aop.model.Category;
import edu.miu.eanov2022aop.repository.CategoryRepository;
import edu.miu.eanov2022aop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepo;

    @Override
    public List<Category> getAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Optional<Category> getById(long id) {
        return categoryRepo.findById(id);
    }

    @Override
    public Category add(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public Category updateById(long id, Category category) {
        Category newCategory = categoryRepo.getReferenceById(id);
        newCategory.setName(category.getName());
        newCategory.setProducts(category.getProducts());
        return categoryRepo.save(newCategory);
    }

    @Override
    public void deleteById(long id) {
        categoryRepo.deleteById(id);
    }
}
