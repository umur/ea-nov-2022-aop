package miu.edu.lab4.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user1")
public class User {
    @Id
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;

    /*@OneToMany
    @JoinColumn(name = "user_id")
    private List<Review> reviews;

     */

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
}
