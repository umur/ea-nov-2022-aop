package com.example.productreviewapplication.model.unidirectional.joincolumn;

import com.example.productreviewapplication.model.unidirectional.jointable.Review1;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Product2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    private Integer rating;

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<Review1> reviews;

}
