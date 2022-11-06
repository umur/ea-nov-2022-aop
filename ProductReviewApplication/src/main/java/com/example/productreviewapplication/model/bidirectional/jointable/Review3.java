package com.example.productreviewapplication.model.bidirectional.jointable;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Review3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String comment;

    @ManyToOne
    private Customer3 customer3;

    @ManyToOne
    private Product3 product3;

}
