package com.example.lab3.entity.userAddressJoinCol;

import lombok.Data;

import javax.persistence.*;

//@Entity(name="UserAccount")
@Data
@Table(name = "UserInfo")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @OneToOne
    @JoinColumn(name = "id_address")
    private Address address;
}
