package miu.edu.ea_day3_crudwithdb.DTO;

import lombok.Data;

@Data
public class UserDto {
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
