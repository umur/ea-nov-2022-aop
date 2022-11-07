package com.example.Product.Review.entities.join_table;

import com.example.Product.Review.entities.join_column.Product;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class TReview {

    @Id
    private long id;
    private String comment;

    @ManyToOne
    private Product product;

    @ManyToOne
    private TUser user;
}
