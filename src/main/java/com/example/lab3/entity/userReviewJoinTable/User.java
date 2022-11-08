package com.example.lab3.entity.userReviewJoinTable;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

//@Entity(name="UserAccount")
@Data
@Table(name = "UserInfo")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @OneToMany
    @JoinTable
    private List<Review> reviews;

}
