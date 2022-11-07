package com.example.Product.Review.entities.bi_directional;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class BiUser {

    @Id
    private long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "user")
    private List<BiReview> reviews;

    @OneToOne(mappedBy = "user")
    private BiAddress address;
}
