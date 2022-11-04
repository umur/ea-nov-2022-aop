package com.waa.springdata.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class SimpleProductDto {
    private int id;
    private String name;
    private int price;
    private double rating;
    private int category_id;
    private String category_name;

    public SimpleProductDto(int id, String name, int price, double rating, int category_id, String category_name) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.category_id = category_id;
        this.category_name = category_name;
    }
}
