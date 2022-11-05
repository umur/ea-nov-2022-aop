package edu.miu.aop.aop.service;

import edu.miu.aop.aop.dto.RequestProductDTO;
import edu.miu.aop.aop.entity.Product;

import java.util.List;

/**
 * Author: Kuylim TITH
 * Date: 11/3/2022
 */
public interface ProductService {

    RequestProductDTO save(RequestProductDTO product);

    RequestProductDTO update(Long id, RequestProductDTO product);

    List<Product> getAllProduct();

    List<Product> getAllProductGreaterThanMinPrice(Double minPrice);

    List<Product> getAllProductByCategoryAndLessThanMaxPrice(String catName, Double maxPrice);

    List<Product> getAllProductByNameContain(String keyword);
}
