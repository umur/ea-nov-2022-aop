package com.example.productreviewapplication.model.unidirectional.jointable;

import javax.persistence.*;

@Entity
public class Address1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String street;
    private String zip;
    private String city;
}
