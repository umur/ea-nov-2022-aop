package edu.miu.eanov2022aop.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String zip;
    private String city;
    @OneToOne(mappedBy = "address")
    private User user;
}
