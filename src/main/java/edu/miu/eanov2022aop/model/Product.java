package edu.miu.eanov2022aop.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private double rating;
    @ManyToOne
    private Category category;
    @OneToMany(mappedBy = "product")
    private List<Review> reviews;
}
