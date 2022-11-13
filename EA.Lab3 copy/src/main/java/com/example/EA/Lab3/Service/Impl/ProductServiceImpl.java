package com.example.EA.Lab3.Service.Impl;

import com.example.EA.Lab3.DTO.ProductDTO;
import com.example.EA.Lab3.DTO.ReviewDTO;
import com.example.EA.Lab3.Entity.Category;
import com.example.EA.Lab3.Entity.Product;
import com.example.EA.Lab3.Repo.ProductRepo;
import com.example.EA.Lab3.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final ModelMapper modelMapper;

    public List<ProductDTO> findAll(){
        List<ProductDTO> mappedProducts = new ArrayList<>();
        productRepo.findAll()
                .forEach(product -> mappedProducts.add(modelMapper.map(product, ProductDTO.class)));
        return mappedProducts;
    }
    public ProductDTO save(ProductDTO product){
        Product mappedPoduct = modelMapper.map(product, Product.class);
        return modelMapper.map(productRepo.save(mappedPoduct), ProductDTO.class);
    }

    public ProductDTO update(Long id, ProductDTO product){
        Product mappedProduct = modelMapper.map(product, Product.class);
        return modelMapper.map(productRepo.save(mappedProduct), ProductDTO.class);
    }
    public void delete(Long id){
        Product product = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Invalid ID !"));
        productRepo.delete(product);
       // modelMapper.map(product, ProductDTO.class);
    }
    public List<ProductDTO> findMoreThanMinPrice(Long minPrice){
        List<ProductDTO> mappedProducts = new ArrayList<>();
        productRepo.findAllByPriceGreaterThanEqual(minPrice).forEach(product -> mappedProducts.add(modelMapper.map(product, ProductDTO.class)));
        return mappedProducts;
    }
    public List<ProductDTO> findCategoryAndLessThanMaxPrice(Category category, Long maxPrice){
        List<ProductDTO> mappedProduct = new ArrayList<>();
        productRepo.findAllByCategoryAndPriceLessThanEqual(category, maxPrice).forEach(product -> mappedProduct.add(modelMapper.map(product, ProductDTO.class)));
        return mappedProduct;
    }
    public List<ProductDTO> findContainsKeyword(String keyword){
        List<ProductDTO> mappedProduct = new ArrayList<>();
        productRepo.findAllByNameContains(keyword).forEach(product -> mappedProduct.add(modelMapper.map(product, ProductDTO.class)));
   return mappedProduct;
    }

    public List<ReviewDTO> findReviewsOfProduct(Long id) {
        List<ReviewDTO> mappedReview = new ArrayList<>();
        Product product = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Invalid ID !"));
        product.getReviews().forEach(review -> mappedReview.add(modelMapper.map(review, ReviewDTO.class)));
        return mappedReview;
    }
}
