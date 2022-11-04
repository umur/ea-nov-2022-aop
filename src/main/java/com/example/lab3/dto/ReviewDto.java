package com.example.lab3.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

@Data
public class ReviewDto {
    private Long id;
    private String comment;

    private ProductDto product;
    @JsonManagedReference
    private UserDto user;
}