package com.example.lab3springdata.model.uni_directional;


import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @OneToMany
    @Fetch(value = FetchMode.JOIN)
    @JoinColumn(name = "user_id")
    List<Review> reviews;

    @OneToOne
    private Address address;

}
