package miu.edu.ea_day3_crudwithdb.entity.unidirectional;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "UserUni")
@Data
@Table(name = "usersUni")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;

    @OneToOne
    @JoinColumn(name = "id_address")
    private Address address;

}
