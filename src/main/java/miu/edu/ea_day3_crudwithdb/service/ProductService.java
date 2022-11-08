package miu.edu.ea_day3_crudwithdb.service;

import miu.edu.ea_day3_crudwithdb.DTO.ProductDto;
import miu.edu.ea_day3_crudwithdb.DTO.ReviewDto;
import miu.edu.ea_day3_crudwithdb.entity.Product;

import java.util.List;

public interface ProductService {
    void save(ProductDto product);

    void delete(int id);

    ProductDto getById(int id);

    List<ProductDto> getAll();

    void update(int id, ProductDto product);

    List<ProductDto> getProductsGreaterThanMinPrice(Double minPrice);

    List<ProductDto> getProductsByName(String keyword);

    List<ReviewDto> getReviewByProductId(int productId);

}
