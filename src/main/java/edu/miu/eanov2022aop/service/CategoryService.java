package edu.miu.eanov2022aop.service;

import edu.miu.eanov2022aop.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    public List<Category> getAll();
    public Optional<Category> getById(long id);
    public Category add(Category category);
    public Category updateById(long id, Category category);
    public void deleteById(long id);
}
