package edu.miu.springdata.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "tbl_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fld_category_id")
    private Long id;

    @Column(name = "fld_category_name", nullable = false)
    private String name;

    @OneToMany
    @JoinColumn(name = "fld_category_id_fk")
    private List<Product> products;

}
