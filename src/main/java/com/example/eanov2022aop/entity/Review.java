package com.example.eanov2022aop.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String comment;

    @ManyToOne
    private Product product;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;

}
