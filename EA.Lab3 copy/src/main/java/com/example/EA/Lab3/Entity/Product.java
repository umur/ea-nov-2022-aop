package com.example.EA.Lab3.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private Double rating;

    @ManyToOne
    private Category category;
    @OneToMany(mappedBy = "product")
    private List<Review> reviews;
}
