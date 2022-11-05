package com.example.springaop.entities.DTOs;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String address;
}
