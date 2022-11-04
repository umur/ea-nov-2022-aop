package com.example.lab3.dto;

import lombok.Data;

@Data
public class AddressDto {
    private Long id;
    private String street;
    private String zip;
    private String city;

}