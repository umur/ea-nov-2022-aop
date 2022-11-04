package com.gyawalirajiv.data.services.impl;

import com.gyawalirajiv.data.AOP.ExecutionTime;
import com.gyawalirajiv.data.models.DTOs.ProductDTO;
import com.gyawalirajiv.data.models.DTOs.ReviewDTO;
import com.gyawalirajiv.data.models.Product;
import com.gyawalirajiv.data.repository.ProductRepository;
import com.gyawalirajiv.data.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        return modelMapper.map(productRepository.save(modelMapper.map(productDTO, Product.class)), ProductDTO.class);
    }

    @ExecutionTime
    @Override
    public List<ProductDTO> findAll() {
        return productRepository.findAll().stream().map(u -> modelMapper.map(u, ProductDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ProductDTO find(Long id) {
        return modelMapper.map(productRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid ID!")), ProductDTO.class);
    }

    @Override
    public List<ProductDTO> findProductMinPrice(Integer minPrice) {
        return productRepository.findAllByPriceGreaterThan(minPrice)
                .stream().map(p -> modelMapper.map(p, ProductDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findProductContainingKeyword(String keyword) {
        return productRepository.findAllByNameContaining(keyword)
                .stream().map(p -> modelMapper.map(p, ProductDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ReviewDTO> findReviewsOfProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid ID!")).getReviews()
                .stream().map(r -> modelMapper.map(r, ReviewDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ProductDTO update(Long id, ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        product = productRepository.save(product);
        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    public ProductDTO delete(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid ID!"));
        productRepository.delete(product);
        return modelMapper.map(product, ProductDTO.class);
    }
}
