package com.example.productreviewapplication.model.bidirectional.joincolumn;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Review4 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String comment;

    @ManyToOne
    private Customer4 customer;

    @ManyToOne
    private Product4 product;

}
