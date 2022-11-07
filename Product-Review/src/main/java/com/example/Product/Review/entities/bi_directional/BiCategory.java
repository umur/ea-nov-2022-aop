package com.example.Product.Review.entities.bi_directional;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class BiCategory {

    @Id
    private long id;
    private String comment;

    @OneToMany(mappedBy = "category")
    private List<BiProduct> products;
}
