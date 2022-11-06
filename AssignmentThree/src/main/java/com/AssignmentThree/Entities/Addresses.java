package com.AssignmentThree.Entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Addresses {
    @Id
    private int id;
    private String street;
    private String zip;
    private String city;
}
