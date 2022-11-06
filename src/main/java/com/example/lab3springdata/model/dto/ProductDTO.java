package com.example.lab3springdata.model.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private int id;
    private String name;
    private double price;
    private int rating;
//    private Category category;
//    private List<Review> reviews;
}
