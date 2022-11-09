package com.aop.springaop.springdatabidirectional.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    //bidirectional
    @OneToOne(mappedBy = "user")
    @JoinColumn
    private Address address;

    @OneToMany(mappedBy = "user")
   private List<Review>reviews;
}
