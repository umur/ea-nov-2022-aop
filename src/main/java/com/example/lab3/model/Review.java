package com.example.lab3.model;

import javax.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
