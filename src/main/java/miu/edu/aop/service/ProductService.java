package miu.edu.aop.service;

import miu.edu.aop.dto.ProductDTO;
import miu.edu.aop.model.Category;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDTO> findAll();
    Optional<ProductDTO> findOne(Long id);
    ProductDTO save(ProductDTO product);
    void delete(Long id);

    List<ProductDTO> findAllWithMinPrice(Double price);

    List<ProductDTO> findAllWithCategoryAndMaxPrice(Category category, Double price);

    List<ProductDTO> findAllWithNameContains(String term);
}
