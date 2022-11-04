package com.gyawalirajiv.data.models.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    private String name;
    private Integer price;
    private Integer rating;
    @JsonIgnore
    private CategoryDTO category;
    private List<ReviewDTO> reviews;

}
