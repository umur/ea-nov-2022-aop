package com.example.eanov2022aop.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Integer id;
    private String name;
    private double price;
    private String rating;

    private CategoryDto category;

}
