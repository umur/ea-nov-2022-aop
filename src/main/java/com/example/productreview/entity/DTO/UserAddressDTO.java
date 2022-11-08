package com.example.productreview.entity.DTO;

import lombok.Data;

@Data
public class UserAddressDTO {
    private String email;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
}
