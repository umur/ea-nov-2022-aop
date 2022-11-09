package com.example.lab3springdata.service.Impl;

import com.example.lab3springdata.aspect.ExecutionTime;
import com.example.lab3springdata.model.uni_directional.Product;
import com.example.lab3springdata.repo.ProductRepository;
import org.springframework.stereotype.Service;
import com.example.lab3springdata.service.ProductService;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void create(Product product) {
        productRepository.save(product);
    }

    @Override
    @ExecutionTime
    public Product update(int id, Product product) {
        Product productById = productRepository.findById(id).get();
        productById.setId(productById.getId());
        productById.setName(productById.getName());
        productById.setCategory(product.getCategory());
        productById.setRating(product.getRating());
        productRepository.save(productById);
        return productById;
    }

    @Override
    public void delete(int id) {
        Product productById = productRepository.findById(id).get();
        productRepository.delete(productById);
    }

    @Override
    public List<Product> findAllByPriceGreaterThan(double price) {
        return productRepository.findAllByPriceGreaterThan(price);
    }

    @Override
    public List<Product> findAllByCategory_NameAndPriceIsLessThan(String name, double price) {
        return productRepository.findAllByCategory_NameAndPriceIsLessThan(name, price);
    }

    @Override
    public List<Product> findAllByNameContaining(String name) {
        return productRepository.findAllByNameContaining(name);
    }


    // extra


}
