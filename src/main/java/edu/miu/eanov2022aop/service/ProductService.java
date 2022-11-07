package edu.miu.eanov2022aop.service;

import edu.miu.eanov2022aop.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public List<Product> getAll();
    public Optional<Product> getById(long id);
    public Product add(Product product);
    public Product updateById(long id, Product product);
    public void deleteById(long id);
}
