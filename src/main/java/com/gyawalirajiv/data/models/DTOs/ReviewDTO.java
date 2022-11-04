package com.gyawalirajiv.data.models.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {

    private Long id;
    private String comment;
    @JsonIgnore
    private UserDTO user;
    @JsonIgnore
    private ProductDTO product;

}
