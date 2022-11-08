package miu.edu.ea_day3_crudwithdb.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    @OneToOne
    @JoinColumn(name = "id_address")
    private Address address;

}
