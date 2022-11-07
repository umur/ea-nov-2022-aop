package com.example.Product.Review.entities.uni_directional;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class UniProduct {

    @Id
    private long id;
    private String name;
    private double price;
    private short rating;

    @ManyToOne
    private UniCategory category;

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<UniReview> reviews;
}
