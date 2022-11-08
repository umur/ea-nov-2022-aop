package com.example.eanov2022aop.dto;

import lombok.Data;

import java.util.List;

@Data
public class UsersDto {
    private Integer id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;


    private List <ReviewDto> reviews;

    private AddressDto address;
}
