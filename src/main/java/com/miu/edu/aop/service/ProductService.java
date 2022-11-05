package com.miu.edu.aop.service;

import com.miu.edu.aop.dto.ProductDto;

import java.util.List;

public interface ProductService {

    /**
     * Get all products
     * @return all products
     */
    List<ProductDto> getAllProducts();

    /**
     * Search Products By Name
     * @param name
     * @return list of products
     */
    List<ProductDto> searchProductsByName(String name);

    /**
     * Get all products By CategoryId
     * @return all products
     */
    List<ProductDto> getAllProductsByCategoryId(int categoryId);

    /**
     * Get product by id
     * @return product
     */
    ProductDto getProductById(int id);

    /**
     * Update a product
     * @param product
     */
    void updateProduct(ProductDto product);

    /**
     * Add a product
     * @param product
     */
    void addProduct(ProductDto product);

    /**
     * Remove a product by id
     * @param id
     */
    void removeById(int id);

    /**
     * Find all products that cost more than minPrice.
     * @param minPrice
     */
    List<ProductDto> findProductsByPriceGreaterThanEqual(Double minPrice);

    /**
     * Find all products in a category and cost less than maxPrice.
     * @param maxPrice
     */
    List<ProductDto> findProductsByCategoryIdAndPriceLessThanEqual(int id, Double maxPrice);
}
