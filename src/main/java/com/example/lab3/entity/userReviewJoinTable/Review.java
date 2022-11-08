package com.example.lab3.entity.userReviewJoinTable;

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
    private User user;

}
