package miu.edu.ea_day3_crudwithdb.entity.unidirectional;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "ProductUni")
@Data
@Table(name = "productsUni")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private double rating;
    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;
}
