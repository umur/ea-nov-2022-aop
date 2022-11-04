package com.example.lab3.entity.userReviewJoinCol;

import lombok.Data;

import javax.persistence.*;

//@Entity
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    @ManyToOne
    @JoinColumn
    private User user;

}
