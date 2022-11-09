package com.example.lab3springdata.model.uni_directional;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Data
//@RequiredArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "category")
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NonNull
    private String name;

//    @OneToMany
//    @JoinColumn(name = "category_id")

//    @Fetch(value = FetchType.EAGER)
//    @JsonManagedReference
//    List<Product> products;
}
