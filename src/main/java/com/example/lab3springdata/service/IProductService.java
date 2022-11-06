package com.example.lab3springdata.service;

import com.example.lab3springdata.model.dto.ProductDTO;

import java.util.List;

@SuppressWarnings("unused")
public interface IProductService {
    //Find all products that cost more than `minPrice`.
    List<ProductDTO> findProductsByPrice(double minPrice);

    List<ProductDTO> findProductsByCategory_NameAndPriceLessThan(String category_name, double price);

    List<ProductDTO> findAllByNameContaining(String filterText);

    ProductDTO getProductById(int id);

    void addProduct(ProductDTO productDTO);
}
