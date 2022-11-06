package com.example.productreviewapplication.model.bidirectional.jointable;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Product3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    private Integer rating;

    @OneToMany
    private List<Review3> reviews;

    @ManyToOne
    private Category3 category3;

}
