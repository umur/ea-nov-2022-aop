package edu.miu.springdata.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fld_user_id")
    private Long id;

    @Column(name = "fld_email", nullable = false)
    private String email;

    @Column(name = "fld_password", nullable = false)
    private String password;

    @Column(name = "fld_firstname", nullable = false)
    private String firstName;

    @Column(name = "fld_lastname", nullable = false)
    private String lastName;

    @OneToMany
    @JoinColumn(name = "fld_user_id_fk")
    private List<Review> reviews;

}
