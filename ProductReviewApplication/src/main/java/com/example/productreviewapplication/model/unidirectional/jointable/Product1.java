package com.example.productreviewapplication.model.unidirectional.jointable;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Product1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    private Integer rating;

    @OneToMany
    private List<Review1> reviews;

}
