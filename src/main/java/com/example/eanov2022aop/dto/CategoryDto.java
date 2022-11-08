package com.example.eanov2022aop.dto;

import lombok.Data;

import java.util.List;
@Data
public class CategoryDto {
    private Integer id;
    private String name;

    private List <ProductDto> products;
}
