package com.example.lab3.entity.unidirectional;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

//@Entity
@Data
@Table(name = "product-uni")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long price;
    private Double rating;

    @OneToOne
    private Category category;

    @OneToMany
    private List<Review> reviews;
}
