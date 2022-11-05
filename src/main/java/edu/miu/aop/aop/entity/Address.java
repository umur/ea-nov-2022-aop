package edu.miu.aop.aop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Author: Kuylim TITH
 * Date: 11/2/2022
 */
@Setter
@Getter
@Entity(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String street;
    private String zip;
    private String city;

    @JsonIgnore
    @OneToOne(mappedBy = "address")
    private User user;
}
