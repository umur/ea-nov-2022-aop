package com.example.productreview.service.Impl;

import com.example.productreview.entity.DTO.DTOConverter;
import com.example.productreview.entity.DTO.ProductDTO;
import com.example.productreview.entity.uni_and_bi_directional.Category;
import com.example.productreview.entity.uni_and_bi_directional.Product;
import com.example.productreview.repository.ProductRepo;
import com.example.productreview.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    DTOConverter dtoConverter;

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepo.findById(id).get();
    }

    @Override
    public void add(Product product) {
        productRepo.save(product);
    }

    @Override
    public void update(Long id, Product product) {
        Product oldProduct = productRepo.findById(id).get();
        oldProduct.setName(product.getName());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setRating(product.getRating());
        productRepo.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepo.deleteById(id);
    }

    @Override
    public List<Product> findAllByPriceGreaterThan(double price) {
        return productRepo.findAllByPriceGreaterThan(price);
    }

    @Override
    public List<Product> findAllByNameContaining(String keyword) {
        return productRepo.findAllByNameContaining(keyword);
    }

    @Override
    public List<ProductDTO> findAllByPriceGreaterThanJPQL(double price) {
        return productRepo.findAllByPriceGreaterThanJPQL(price).stream()
                .map(product -> dtoConverter.productToDTO(product))
                .toList();
    }

    @Override
    public List<ProductDTO> findAllByNameContainingJPQL(String keyword) {
        return productRepo.findAllByNameContainingJPQL(keyword).stream()
                .map(product -> dtoConverter.productToDTO(product))
                .toList();
    }

    @Override
    public List<ProductDTO> findAllByCategoryEqualsAndPriceLessThan(Category category, double price) {
        return productRepo.findAllByCategoryEqualsAndPriceLessThan(category, price).stream()
                .map(product -> dtoConverter.productToDTO(product))
                .toList();
    }
}
