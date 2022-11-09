package com.example.lab3springdata.dto;

import com.example.lab3springdata.model.uni_directional.Product;
import lombok.Data;

import java.io.Serializable;


@Data
public class ReviewDTO {
    private String comment;
    Product product;

}
