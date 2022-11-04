package com.example.lab3.entity.unidirectional;

import lombok.Data;

import javax.persistence.*;

//@Entity
@Data
@Table(name = "Address-uni")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String zip;
    private String city;
}
