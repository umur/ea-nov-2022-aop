package edu.miu.aop.aop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Author: Kuylim TITH
 * Date: 11/2/2022
 */
@Setter
@Getter
@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String password;
    private String firstname;
    private String lastname;

    @OneToOne
    private Address address;

    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private List<Review> reviews;
}
