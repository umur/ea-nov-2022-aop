package com.AssignmentThree.Entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Reviews {
    @Id
    private int id;
    private String comment;

    @ManyToOne
    Users user;
    @ManyToOne
    Products product;

}
