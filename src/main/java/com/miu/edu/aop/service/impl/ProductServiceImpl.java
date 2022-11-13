package com.miu.edu.aop.service.impl;

import com.miu.edu.aop.annotation.ExecutionTime;
import com.miu.edu.aop.entity.Product;
import com.miu.edu.aop.dto.ProductDto;
import com.miu.edu.aop.exception.NotFoundException;
import com.miu.edu.aop.repository.ProductRepository;
import com.miu.edu.aop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @ExecutionTime
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(ProductDto::convertFrom).toList();
    }

    @Override
    @ExecutionTime
    public List<ProductDto> searchProductsByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name).stream().map(ProductDto::convertFrom).toList();
    }

    @Override
    @ExecutionTime
    public List<ProductDto> getAllProductsByCategoryId(int categoryId) {
        return productRepository.getProductsByCategoryId(categoryId).stream().map(ProductDto::convertFrom).toList();
    }

    @Override
    @ExecutionTime
    public ProductDto getProductById(int id) {
        return ProductDto.convertFrom(
                productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Can't find the product with id "))
        );
    }

    @Override
    public void updateProduct(int id, ProductDto product) {
        productRepository.findById(id).ifPresent(p -> {
            p.setName(product.getName());
            p.setPrice(product.getPrice());
            p.setRating(product.getRating());
            productRepository.save(p);
        });
    }

    @Transactional
    @Override
    public ProductDto addProduct(ProductDto productDto) {
        return ProductDto.convertFrom(productRepository.save(ProductDto.convertTo(productDto)));
    }

    @Transactional
    @Override
    public void removeById(int id) {
        productRepository.deleteById(id);
    }

    @Override
    @ExecutionTime
    public List<ProductDto> findProductsByPriceGreaterThanEqual(Double minPrice) {
        return productRepository.findProductsByPriceGreaterThanEqual(minPrice).stream()
                .map(ProductDto::convertFrom)
                .toList();
    }

    @Override
    @ExecutionTime
    public List<ProductDto> findProductsByCategoryIdAndPriceLessThanEqual(int id, Double maxPrice) {
        return productRepository.findProductsByCategory_IdAndPriceLessThanEqual(id, maxPrice).stream()
                .map(ProductDto::convertFrom)
                .toList();
    }

    @Override
    public List<ProductDto> findProductByPriceGreaterThanEqualAndNameContainingIgnoreCase(Double price, String name) {
        return productRepository.findProductByPriceGreaterThanEqualAndNameContainingIgnoreCase(price, name).stream()
                .map(ProductDto::convertFrom)
                .toList();
    }
}
