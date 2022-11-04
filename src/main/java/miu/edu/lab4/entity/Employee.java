package miu.edu.lab4.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Employee {
    @EmbeddedId
    private EmployeeId id;

    // Embedded if its not a primary key

    private String email;
    private String phone;
    private String address;
    private String city;



}
