package miu.edu.lab4.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    private int id;
    private String name;
    private double price;
    private int rating;


    /* we can use DTO to provide specific data to the client
    and we can map the DTO to the entity in the service layer vice versa
    NOT for exam but for real life
     */

    @ManyToOne()
    Category category;

    /*
    @OneToMany()
    @JoinColumn()
    List<Review> reviews;
     */

}
