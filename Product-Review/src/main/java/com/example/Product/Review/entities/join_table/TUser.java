package com.example.Product.Review.entities.join_table;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class TUser {

    @Id
    private long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @OneToMany
    @JoinTable(
            name = "user_review",
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            joinColumns = @JoinColumn(name = "rev_id", referencedColumnName = "id")
    )
    private List<TReview> reviews;

    @OneToOne(mappedBy = "user")
    private TAddress address;
}
