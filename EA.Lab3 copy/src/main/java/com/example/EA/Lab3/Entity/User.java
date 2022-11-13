package com.example.EA.Lab3.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;

    private String firstName;
    private String lastName;
    private String password;
    @OneToOne
    private Address address;
    @OneToMany(mappedBy = "user")
    private List<Review> reviews;
}
