package com.AssignmentThree.Entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Categories {
    @Id
    private int id;
    private String name;
    @OneToMany
    private List<Products> products;
}
