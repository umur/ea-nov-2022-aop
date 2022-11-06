package com.example.productreviewapplication.model.bidirectional.jointable;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Customer3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String password;
    private String lastName;
    private String firstName;

    @OneToMany
    private List<Review3> reviews;

}
