package com.example.lab3springdata.model.bi_directional;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;


@Data
//@RequiredArgsConstructor
//@AllArgsConstructor
@NoArgsConstructor
//@Entity
@Table(name = "bi_category")
public class Category {
    @Id
    @GeneratedValue
    private int id;

    @NonNull
    private String name;

    @OneToMany(mappedBy = "category")
    List<Product> products;


    public Category(@NonNull String name) {
        this.name = name;
    }
}

/*
     create table bi_category (
     id int4 not null,
     name varchar(255),
     primary key (id)
     )
 */

