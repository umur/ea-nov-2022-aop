package com.example.Product.Review.entities.uni_directional;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class UniUser {

    @Id
    private long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @OneToOne
    private UniAddress address;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<UniReview> reviews;
}
