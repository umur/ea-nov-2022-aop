package com.example.eanov2022springdataI.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

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
