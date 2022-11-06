package com.example.lab3.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @OneToMany //uni-directional
    @JoinColumn(name = "user1_id")
    private List<Review> reviews;

    @OneToOne
    private Address address;
}
