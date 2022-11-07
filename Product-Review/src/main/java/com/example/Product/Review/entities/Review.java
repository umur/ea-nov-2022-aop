package com.example.Product.Review.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Review {

    @Id
    private long id;
    private String comment;

    @ManyToOne
    private Product product;

    @ManyToOne
    private User user;
}
