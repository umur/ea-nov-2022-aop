package com.example.eanov2022aop.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;
    private String password;
    private String firstname;
    private String lastname;

    @OneToMany(mappedBy = "users",cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List <Review> reviews;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
   // @JoinColumn(name = "address_id")
    private Address address;

}
