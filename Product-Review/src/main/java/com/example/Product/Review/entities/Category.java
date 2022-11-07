package com.example.Product.Review.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Category {

    @Id
    private long id;
    private String comment;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
