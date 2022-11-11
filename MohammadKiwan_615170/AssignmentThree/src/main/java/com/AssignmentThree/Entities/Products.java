package com.AssignmentThree.Entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Products {
    @Id
    private int id;
    private String name;
    private double price;
    private double rating;
    @OneToMany
    private List<Reviews> reviews;
}
