package edu.miu.eanov2022aop.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "user")
    private List<Review> reviews;
    @OneToOne
    private Address address;

}
