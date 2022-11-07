package com.example.Product.Review.entities.join_table;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class TAddress {

    @Id
    private long id;
    private String street;
    private String zip;
    private String city;

    @OneToOne
    @JoinTable(
            name = "user_address",
            joinColumns = @JoinColumn(name = "add_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
    )
    private TUser user;
}
