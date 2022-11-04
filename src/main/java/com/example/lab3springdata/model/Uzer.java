package com.example.lab3springdata.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Data
@Entity
public class Uzer {

    @Id
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @OneToOne
    //@JoinColumn//(name = "address_id")
    @JsonManagedReference
    private Address address;

    @OneToMany(mappedBy = "uzer")
    @JsonBackReference
    private List<Review> reviews;
}
