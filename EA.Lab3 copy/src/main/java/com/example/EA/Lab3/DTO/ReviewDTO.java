package com.example.EA.Lab3.DTO;

import com.example.EA.Lab3.Entity.Product;
import com.example.EA.Lab3.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private Long id;
    private String comment;
    private UserDTO user;
    private ProductDTO product;
}
