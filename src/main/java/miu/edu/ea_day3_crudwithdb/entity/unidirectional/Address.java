package miu.edu.ea_day3_crudwithdb.entity.unidirectional;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "AddressUni")
@Data
@Table(name = "addressesUni")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String zip;
    private String city;
}
