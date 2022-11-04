package miu.edu.lab4.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Review {
    @Id
    private int id;
    private String comment;

    @ManyToOne()
    Product product;

    @ManyToOne()
    User user;

    /*
    in the case of bidirectional relationship to avoid infinite recursion when serializing (not from DB ref)
    @JsonManagedReference - used on the parent side of the relationship to avoid infinite recursion
    @JsonBackReference - used on the child side of the relationship to avoid infinite recursion
     */


}
