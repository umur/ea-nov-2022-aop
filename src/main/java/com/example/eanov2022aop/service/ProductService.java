package com.example.eanov2022aop.service;



import com.example.eanov2022aop.dto.ProductDto;

import java.util.List;

public interface ProductService {
    public List <ProductDto> findAll ();

    public ProductDto findProductById (Integer id);

    void create (ProductDto productDto);

    void delete (Integer id);

    void update(Integer id,String name,double price);

    List<ProductDto> findProductsByPrice (double minprice);
    List<ProductDto> findByCategory_IdAndPrice(Integer id, double maxPrice);
    List<ProductDto> findProductsByNameContains(String keyword);
}
