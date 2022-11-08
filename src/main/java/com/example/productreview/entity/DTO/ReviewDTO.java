package com.example.productreview.entity.DTO;

import lombok.Data;

@Data
public class ReviewDTO {
    private long reviewId;
    private String comment;
    private String firstName;
    private String lastName;
    private String productName;
    private double price;

}
