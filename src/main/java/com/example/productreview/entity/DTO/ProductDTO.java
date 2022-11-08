package com.example.productreview.entity.DTO;

import com.example.productreview.entity.uni_and_bi_directional.Category;
import com.example.productreview.entity.uni_and_bi_directional.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private Integer price;
    private Integer rating;
    @JsonIgnore
    private Category category;
    private List<Review> reviews;
}
