package com.example.EA.Lab3.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String zip;
    private String city;

}
