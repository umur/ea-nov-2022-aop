package com.miu.edu.aop.dto;

import com.miu.edu.aop.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private int id;

    private String email;

    private String password;

    private String firstName;

    private String lastname;

    private AddressDto address;

    public UserDto(int id, String email, String firstName, String lastname, AddressDto address) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastname = lastname;
        this.address = address;
    }

    public static UserDto convertFrom(User user) {
        if (user == null) {
            return null;
        }
        return new UserDto(
            user.getId(),
            user.getEmail(),
            user.getFirstName(),
            user.getLastname(),
            AddressDto.convertFrom(user.getAddress())
        );
    }

    public static User convertTo(UserDto user) {
        if (user == null) {
            return null;
        }
        return new User(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastname(),
                AddressDto.convertTo(user.getAddress()),
                new ArrayList<>()
        );
    }
}
