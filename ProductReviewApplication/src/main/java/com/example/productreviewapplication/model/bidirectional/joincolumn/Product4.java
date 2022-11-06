package com.example.productreviewapplication.model.bidirectional.joincolumn;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Product4 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    private Integer rating;

    @OneToMany(mappedBy = "product")
    private List<Review4> reviews;

    @ManyToOne
    private Category4 category;

}
