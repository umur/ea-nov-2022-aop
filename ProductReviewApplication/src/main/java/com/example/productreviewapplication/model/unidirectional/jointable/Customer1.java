package com.example.productreviewapplication.model.unidirectional.jointable;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Customer1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String password;
    private String lastName;
    private String firstName;

    @OneToMany
    private List<Review1> reviews;

    @OneToOne
    private Address1 address;
}
