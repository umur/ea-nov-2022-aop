package com.example.lab3springdata.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

//@Table(name = "REVIEW")
@Data
@Entity
public class Review {

    @Id
    private int id;

    //@Column(name = "COMMENT", updatable = false, insertable = false)
    //updateable - it don't will be updated in generated update query
    @Column//(name = "COMMENT")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonManagedReference
    private Product product;

    @ManyToOne
    @JoinColumn(name = "uzer_id")
    @JsonManagedReference
    private Uzer uzer;

}
