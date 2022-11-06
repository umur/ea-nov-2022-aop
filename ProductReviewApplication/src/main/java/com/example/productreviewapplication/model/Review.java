package com.example.productreviewapplication.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String comment;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;
}
