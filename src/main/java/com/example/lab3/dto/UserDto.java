package com.example.lab3.dto;

import com.example.lab3.entity.bidirectional.Address;
import com.example.lab3.entity.bidirectional.Review;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import java.util.List;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Long id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;

    @JsonBackReference
    private List <ReviewDto> reviews;

    private AddressDto address;
}