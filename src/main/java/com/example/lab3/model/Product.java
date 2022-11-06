package com.example.lab3.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private int rating;

    @ManyToOne
    @JoinColumn(name = "cat_id")
    @JsonBackReference
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;
}
