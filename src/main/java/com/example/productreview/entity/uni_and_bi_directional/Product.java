package com.example.productreview.entity.uni_and_bi_directional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private int rating;
    @OneToMany(mappedBy = "product")
    List<Review> reviews;
    @ManyToOne
    @JsonIgnore
    private Category category;
}
