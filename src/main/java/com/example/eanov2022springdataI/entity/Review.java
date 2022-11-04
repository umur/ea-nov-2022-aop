package com.example.eanov2022springdataI.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Review  implements Identifiable{

    @Id
    @Column(name = "id", nullable = false)
    String id;
    String comment;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    Users user;

    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    Product product;
}
