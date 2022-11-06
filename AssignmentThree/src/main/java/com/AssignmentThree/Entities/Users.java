package com.AssignmentThree.Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Users {

    @Id
    int id;
    String email;
    String password;
    @Column(name = "firstName")
    String firstName;
    String lastName;
    @OneToMany
    List<Reviews> reviews;
    @ManyToOne
    Addresses addresses;

}
