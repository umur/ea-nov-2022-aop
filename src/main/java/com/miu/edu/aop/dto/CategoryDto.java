package com.miu.edu.aop.dto;

import com.miu.edu.aop.entity.Category;
import com.miu.edu.aop.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private int id;

    private String name;

    private List<Product> products;

    public static CategoryDto convertFrom(Category category) {
        if (category == null) {
            return null;
        }
        return new CategoryDto(category.getId(), category.getName(), category.getProducts());
    }

    public static Category convertTo(CategoryDto category) {
        if (category == null) {
            return null;
        }
        return new Category(category.getId(), category.getName(), category.getProducts());
    }
}
