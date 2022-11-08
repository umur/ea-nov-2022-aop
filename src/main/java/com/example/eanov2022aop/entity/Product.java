package com.example.eanov2022aop.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double price;
    private String rating;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Category category;

    @OneToMany(mappedBy = "product",cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
   private List <Review> reviews;
}
