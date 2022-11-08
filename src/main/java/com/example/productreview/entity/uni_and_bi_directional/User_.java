package com.example.productreview.entity.uni_and_bi_directional;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class User_ {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "user_")
    List<Review> reviews;
    @JoinColumn(name="address_id")
    @OneToOne(cascade = {CascadeType.ALL})
    private Address address;
}
