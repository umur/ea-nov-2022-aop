package com.example.Product.Review.entities.uni_directional;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class UniAddress {

    @Id
    private long id;
    private String street;
    private String zip;
    private String city;
}
