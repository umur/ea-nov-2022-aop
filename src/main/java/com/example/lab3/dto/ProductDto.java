package com.example.lab3.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private double price;
    private String rating;
    @JsonManagedReference
    private CategoryDto category;

}