package com.example.lab3springdata.model.bi_directional;


import lombok.Data;

import javax.persistence.*;

@Data
//@Entity
@Table(name = "bi_address")
public class Address {

    @Id
    @GeneratedValue
    private int id;

    private String street;
    private String zip;
    private String city;

    @OneToOne(mappedBy = "address") // cancelling creating fk because it is already established on the user(as we chose)
    User user;


}

/*
    create table bi_address (
       id int4 not null,
        city varchar(255),
        street varchar(255),
        zip varchar(255),
        user_id int4,
        primary key (id)
    )
* */

