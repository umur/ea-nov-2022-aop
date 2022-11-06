package com.example.productreviewapplication.model.unidirectional.jointable;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Review1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String comment;

}
