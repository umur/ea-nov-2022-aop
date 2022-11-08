package com.example.eanov2022aop.dto;

import lombok.Data;

@Data
public class ReviewDto {
    private Integer id;
    private String comment;

    private ProductDto product;

    private UsersDto user;
}
