package edu.miu.springdataday3.entity.dto;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDTO{
    private Long id;
    private String name;
    private Double price;
    private Integer rating;
//    @JsonBackReference
    private CategoryDTO category;
}
