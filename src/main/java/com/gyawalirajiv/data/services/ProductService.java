package com.gyawalirajiv.data.services;

import com.gyawalirajiv.data.models.DTOs.ProductDTO;
import com.gyawalirajiv.data.models.DTOs.ReviewDTO;

import java.util.List;

public interface ProductService {
    ProductDTO save(ProductDTO productDTO);

    List<ProductDTO> findAll();

    ProductDTO find(Long id);

    ProductDTO update(Long id, ProductDTO productDTO);

    ProductDTO delete(Long id);

    List<ProductDTO> findProductMinPrice(Integer minPrice);

    List<ProductDTO> findProductContainingKeyword(String keyword);

    List<ReviewDTO> findReviewsOfProduct(Long id);
}
