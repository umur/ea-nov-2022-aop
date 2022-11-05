package edu.miu.aop.aop.service.impl;

import edu.miu.aop.aop.dto.RequestProductDTO;
import edu.miu.aop.aop.entity.Product;
import edu.miu.aop.aop.repository.CategoryRepository;
import edu.miu.aop.aop.repository.ProductRepository;
import edu.miu.aop.aop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Author: Kuylim TITH
 * Date: 11/3/2022
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;

    @Override
    public RequestProductDTO save(RequestProductDTO product) {
        // assume client provide valid category
        Product p = new Product();
        BeanUtils.copyProperties(product, p, "id");
        p.setCategory(categoryRepository.findById(product.getCategoryId()).get());
        repository.save(p);
        return product;
    }

    @Override
    public RequestProductDTO update(Long id, RequestProductDTO product) {
        Optional<Product> optional = repository.findById(id);
        if(optional.isEmpty()) {
            throw new RuntimeException("Product not found!");
        }
        Product p = optional.get();
        BeanUtils.copyProperties(product, p, "id");
        // assume client provide valid category
        p.setCategory(categoryRepository.findById(product.getCategoryId()).get());
        repository.save(p);
        return product;
    }

    @Override
    public List<Product> getAllProduct() {
        return repository.findAll();
    }

    @Override
    public List<Product> getAllProductGreaterThanMinPrice(Double minPrice) {
        return repository.findAllByPriceGreaterThan(minPrice);
    }

    @Override
    public List<Product> getAllProductByCategoryAndLessThanMaxPrice(String catName, Double maxPrice) {
        return repository.findAllByCategoryNameAndPriceLessThan(catName, maxPrice);
    }

    @Override
    public List<Product> getAllProductByNameContain(String keyword) {
        return repository.findAllByNameContains(keyword);
    }
}
