package com.example.lab3springdata.model.bi_directional;


import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Data
//@Entity
@Table(name = "bi_users")
public class User {
    @Id
    @GeneratedValue
    private int id;

    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "user")  // 3 Join Column
//    @OneToMany // 4 Join Table , you can specifiy @JoinTable as well with foreign Key and inverseForeignKey
    @Fetch(value = FetchMode.JOIN)
    List<Review> reviews;

    @OneToOne
    //    @OneToOne(mappedBy = "user") 6 with JoinColumn
//    @JoinTable(name = "address_user", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "address_id")})
    private Address address;

}
