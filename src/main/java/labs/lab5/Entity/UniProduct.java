package labs.lab5.Entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
public class UniProduct {
    @Id
    private String id;
    private String name;
    private String rating;
    private double price;

    @JoinColumn
    @ManyToOne
    UniCategory category;

    @JoinColumn(name = "prod_id")
    @OneToMany
    List<UniReview> reviews;
}
