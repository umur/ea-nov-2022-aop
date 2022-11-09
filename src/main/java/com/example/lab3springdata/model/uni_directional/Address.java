package com.example.lab3springdata.model.uni_directional;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity()
@Table(name = "address")
public class Address {

    @Id
    private int id;
    private String street;
    private String zip;
    private String city;

}
