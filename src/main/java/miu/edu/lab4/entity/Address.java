package miu.edu.lab4.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Address {
    @Id
    private int id;
    private String street;
    private int zipCode;
    private String city;
}
