package com.example.eanov2022springdataI.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address implements Identifiable{

    @Id
    @Column(name = "id", nullable = false)
    String id;
    String street;
    String zip;
    String city;

//    @OneToOne(optional=false, mappedBy="address")
//    Users user;
}
