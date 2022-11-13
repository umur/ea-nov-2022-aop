package com.example.EA.Lab3.DTO;

import com.example.EA.Lab3.Entity.Category;
import com.example.EA.Lab3.Entity.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private Double price;
    private Double rating;

    private CategoryDTO category;
    private List<ReviewDTO> reviews;
}
