package com.example.Product.Review.entities.bi_directional;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class BiReview {

    @Id
    private long id;
    private String comment;

    @ManyToOne
    private BiProduct product;

    @ManyToOne
    private BiProduct user;
}
