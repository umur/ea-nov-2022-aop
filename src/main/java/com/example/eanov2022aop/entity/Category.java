package com.example.eanov2022aop.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Category  implements Identifiable{

    @Id
    @Column(name = "id", nullable = false)
    String id;
    String name;

//    @OneToMany(cascade=ALL, mappedBy="category")
//    @ToString.Exclude
//    Set<Product> products;

}
