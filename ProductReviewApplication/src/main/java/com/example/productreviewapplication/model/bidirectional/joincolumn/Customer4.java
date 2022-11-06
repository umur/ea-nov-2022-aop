package com.example.productreviewapplication.model.bidirectional.joincolumn;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Customer4 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String password;
    private String lastName;
    private String firstName;

    @OneToMany(mappedBy = "customer")
    private List<Review4> reviews;

}
