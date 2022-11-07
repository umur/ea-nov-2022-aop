package edu.miu.springdata.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "tbl_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fld_address_id")
    private Long id;

    @Column(name = "fld_street", nullable = false)
    private String street;

    @Column(name = "fld_zip", nullable = false)
    private String zip;

    @Column(name = "fld_city", nullable = false)
    private String city;

    @OneToOne
    @JoinColumn(name = "fld_user_id_fk")
    private User user;

}
