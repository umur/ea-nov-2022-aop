package edu.miu.eanov2022aop.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    @ManyToOne
    private Product product;
    @ManyToOne
    private User user;
}
