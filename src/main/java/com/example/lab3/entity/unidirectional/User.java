package com.example.lab3.entity.unidirectional;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

//@Entity
@Data
@Table(name = "UserInfo-uni")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @OneToMany
    private List<Review> reviews;

    @OneToOne
    private Address address;
}
