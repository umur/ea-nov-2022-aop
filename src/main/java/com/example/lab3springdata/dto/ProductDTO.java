package com.example.lab3springdata.dto;

import com.example.lab3springdata.model.uni_directional.Rating;
import lombok.Data;


@Data
public class ProductDTO {
    private String name;

    private double price;

    private Rating rating;

}
