package miu.edu.ea_day3_crudwithdb.service;

import miu.edu.ea_day3_crudwithdb.DTO.CategoryDto;
import miu.edu.ea_day3_crudwithdb.DTO.ProductDto;
import miu.edu.ea_day3_crudwithdb.entity.Category;

import java.util.List;

public interface CategoryService {
    void save(CategoryDto category);

    void delete(int id);

    CategoryDto getById(int id);

    List<CategoryDto> getAll();

    void update(int id, CategoryDto category);

    List<ProductDto> getProductsByCategoryAndCostLessThanMaxPrice(String category, double maxPrice);
}
