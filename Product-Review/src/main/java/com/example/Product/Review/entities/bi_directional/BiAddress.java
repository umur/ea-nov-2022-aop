package com.example.Product.Review.entities.bi_directional;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
public class BiAddress {

    @Id
    private long id;
    private String street;
    private String zip;
    private String city;

    @OneToOne
    private BiUser user;
}
