package com.waa.springdata.dto;

import lombok.Data;

@Data
public class UserInterfaceDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String street;
    private String zip;
    private String city;
}

