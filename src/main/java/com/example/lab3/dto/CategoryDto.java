package com.example.lab3.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import java.util.List;
@Data
public class CategoryDto {
    private Long id;
    private String name;


    @JsonBackReference
    private List <ProductDto> products;
}