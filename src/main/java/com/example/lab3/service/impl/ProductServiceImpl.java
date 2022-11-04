package com.example.lab3.service.impl;

import com.example.lab3.dto.CategoryDto;
import com.example.lab3.dto.ProductDto;
import com.example.lab3.dto.ReviewDto;
import com.example.lab3.entity.bidirectional.Category;
import com.example.lab3.entity.bidirectional.Product;
import com.example.lab3.entity.bidirectional.Review;
import com.example.lab3.mapper.Mapper;
import com.example.lab3.repository.CategoryRepo;
import com.example.lab3.repository.ProductRepo;
import com.example.lab3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    private Mapper mapper = new Mapper<Product, ProductDto>(Product.class, ProductDto.class);
    private Mapper mapperReview = new Mapper<Review, ReviewDto>(Review.class, ReviewDto.class);
    @Override
    public List<ProductDto> getAll() {
        return mapper.toListDto((List<Product>) productRepo.findAll());
    }

    @Override
    public ProductDto getProductById(Long id) {
        return (ProductDto) mapper.toDto(productRepo.findById(id).get());
    }

    @Override
    public ProductDto saveProduct(Product product) {
        return (ProductDto) mapper.toDto(productRepo.save(product));
    }

    @Override
    public ProductDto updateProduct(Long id, Product p) {
        var product = productRepo.findById(id).get();
        if(Objects.nonNull(p.getCategory())){
            product.setCategory(p.getCategory());
        }
        if(Objects.nonNull(p.getName())){
            product.setName(p.getName());
        }
        if(Objects.nonNull(p.getRating())){
            product.setRating(p.getRating());
        }
        if(Objects.nonNull(p.getPrice())){
            product.setPrice(p.getPrice());
        }
        return (ProductDto) mapper.toDto(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }

    @Override
    public List<ProductDto> getProductsMinPrice(Long price) {
        if(Objects.isNull(price)) return new ArrayList<>();
        return mapper.toListDto(productRepo.findAllByPriceGreaterThan(price));
    }

    @Override
    public List<ProductDto> getProductsInCategoryWithMaxPrice(String categoryName, Long maxPrice) {
        Category category = categoryRepo.findByNameIs(categoryName);
        if(Objects.isNull(maxPrice) || Objects.isNull(category)) return new ArrayList<>();
        return mapper.toListDto(productRepo.findAllByCategoryIsAndPriceLessThan(category, maxPrice));
    }

    @Override
    public List<ProductDto> searchProductsByName(String keyword) {
        if(Objects.isNull(keyword)) return new ArrayList<>();
        return mapper.toListDto(productRepo.findAllByNameContains(keyword));
    }

    @Override
    public List<ReviewDto> getProductReviews(Long id) {
        var product = productRepo.findById(id).get();
        return mapperReview.toListDto(product.getReviews());
    }
}
