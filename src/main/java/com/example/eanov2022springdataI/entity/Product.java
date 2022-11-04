package com.example.eanov2022springdataI.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Entity
@Data
public class Product  implements Identifiable{

   @Id
   @Column(name = "id", nullable = false)
   String id;
   String name;
   double price;
   double rating;

   @ManyToOne
   @JoinColumn(name="category_id", nullable=false)
   Category category;

//   @OneToMany(cascade=ALL, mappedBy="product")
//   @OneToMany(orphanRemoval = true)
//   @JoinColumn(name="product_id", nullable = false)
//   @ToString.Exclude
//   Set<Review> reviews;
}
