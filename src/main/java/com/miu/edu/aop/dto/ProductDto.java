package com.miu.edu.aop.dto;

import com.miu.edu.aop.entity.Category;
import com.miu.edu.aop.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private int id;

    private Integer categoryId;

    private String name;

    private double price;

    private Integer rating;

    public static ProductDto convertFrom(Product product) {
        if (product == null) {
            return null;
        }
        return new ProductDto(
                product.getId(),
                product.getCategory().getId(),
                product.getName(),
                product.getPrice(),
                product.getRating()
        );
    }

    public static Product convertTo(ProductDto product) {
        if (product == null) {
            return null;
        }

        Category category = null;
        if (product.getCategoryId() != null) {
            category = new Category();
            category.setId(product.getCategoryId());
        }
        return new Product(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getRating(),
                category,
                new ArrayList<>()
        );
    }
}
