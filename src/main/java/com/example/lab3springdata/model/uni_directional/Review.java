package com.example.lab3springdata.model.uni_directional;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "reviews")
public class Review {

    @Id
    private int id;
    private String comment;

    @ManyToOne
    Product product;
}
