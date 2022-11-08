package miu.edu.ea_day3_crudwithdb.entity.unidirectional;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "ReviewUni")
@Data
@Table(name = "reviewsUni")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    @ManyToOne
    @JoinColumn(name ="id_user")
    private User user;
}
