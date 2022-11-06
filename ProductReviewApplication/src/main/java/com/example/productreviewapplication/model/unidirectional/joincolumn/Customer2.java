package com.example.productreviewapplication.model.unidirectional.joincolumn;

import com.example.productreviewapplication.model.unidirectional.jointable.Address1;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Customer2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String password;
    private String lastName;
    private String firstName;

    @OneToMany
    @JoinColumn(name = "customer_id")
    private List<Review2> reviews;

    @OneToOne
    private Address1 address;
}
