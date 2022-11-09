package com.example.lab3springdata.model.bi_directional;


import lombok.Data;

import javax.persistence.*;

@Data
//@Entity
@Table(name = "bi_reviews")
public class Review {

    @Id
    @GeneratedValue
    private int id;

    private String comment;

    @ManyToOne
    Product product;

    @ManyToOne
    User user;
}


/*

    create table bi_reviews (
       id int4 not null,
        comment varchar(255),
        product_id int4,
        user_id int4,
        primary key (id)
    )

 */
