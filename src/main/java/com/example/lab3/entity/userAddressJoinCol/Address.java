package com.example.lab3.entity.userAddressJoinCol;

import lombok.Data;

import javax.persistence.*;

//@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String zip;
    private String city;

    @OneToOne(mappedBy = "address")
    private User user;
}
