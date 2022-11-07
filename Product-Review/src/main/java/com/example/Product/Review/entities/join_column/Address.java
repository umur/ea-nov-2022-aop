package com.example.Product.Review.entities.join_column;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
public class Address {

    @Id
    private long id;
    private String street;
    private String zip;
    private String city;

    @OneToOne
    private User user;
}
