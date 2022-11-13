package com.example.EA.Lab3.DTO;

import com.example.EA.Lab3.Entity.Address;
import com.example.EA.Lab3.Entity.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    private AddressDTO address;
    private List<ReviewDTO> reviews;

}
