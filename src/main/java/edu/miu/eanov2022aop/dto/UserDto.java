package edu.miu.eanov2022aop.dto;

import edu.miu.eanov2022aop.model.Address;
import edu.miu.eanov2022aop.model.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private AddressDto address;
}
