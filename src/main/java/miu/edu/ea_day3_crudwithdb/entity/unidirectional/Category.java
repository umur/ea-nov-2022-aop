package miu.edu.ea_day3_crudwithdb.entity.unidirectional;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "CategoryUni")
@Data
@Table(name = "categoriesUni")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
}
