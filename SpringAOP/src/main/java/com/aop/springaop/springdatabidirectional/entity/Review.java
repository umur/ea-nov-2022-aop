package com.aop.springaop.springdatabidirectional.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    @ManyToOne
    @JoinColumn//optional
    private Product product;
    @ManyToOne
    @JoinColumn//optional
    private User user;
}
