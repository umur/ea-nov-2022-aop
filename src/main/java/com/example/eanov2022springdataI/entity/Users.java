package com.example.eanov2022springdataI.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Users implements Identifiable{

    @Id
    @Column(name = "id", nullable = false)
    String id;
    String email;
    String password;
    String firstName;
    String lastName;

    @OneToOne(optional=false)
    @JoinColumn(name="address_id", unique=true, nullable=false, updatable=false)
    Address address;

}
