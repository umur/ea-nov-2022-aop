package com.aop.springaop.springdatabidirectional.service.Impl;

import com.aop.springaop.aspectAdvice.ExecutionTime;
import com.aop.springaop.springdatabidirectional.entity.Product;
import com.aop.springaop.springdatabidirectional.repository.ProductRepository;
import com.aop.springaop.springdatabidirectional.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);

    }
    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        productRepository.findAll().forEach(productList::add);
        return productList;
    }

    public List<Product> findProductsByPriceIsGreaterThan(double minPrice) {
        return productRepository.findProductsByPriceIsGreaterThan(minPrice);
    }

    public List<Product> findProductsByPriceIsLessThan(double maxPrice) {
        return productRepository.findProductsByPriceIsLessThan(maxPrice);
    }

    public List<Product> findProductsByNameIsLikeIgnoreCase(String name) {
        return productRepository.findProductsByNameIsLikeIgnoreCase(name);
    }

    @Override
    public List<Product> findProductsByReviewsAndIdContaining(Long id) {
        return productRepository.findProductsByReviewsAndIdContaining(id);
    }
}
