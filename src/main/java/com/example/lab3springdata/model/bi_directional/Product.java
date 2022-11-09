package com.example.lab3springdata.model.bi_directional;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

@Data
//@Entity
@Table(name = "bi_products")
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    private double price;

    private Rating rating;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @NonNull
    private Category category;

    @OneToMany(mappedBy = "product")
    List<Review> reviews;


    public Product(String name, double price, Rating rating, @NonNull Category category) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.category = category;
    }

}


/*
    create table bi_products (
       id int4 not null,
        name varchar(255),
        price float8 not null,
        rating int4,
        category_id int4,
        primary key (id)
    )
* */
