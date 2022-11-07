package edu.miu.springdata.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "tbl_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fld_product_id")
    private Long id;

    @Column(name = "fld_product_name", nullable = false)
    private String name;

    @Column(name = "fld_price")
    private double price;

    @Column(name = "fld_rating")
    private double rating;

    @OneToMany
    @JoinColumn(name = "fld_product_id_fk")
    private List<Review> reviews;

}
