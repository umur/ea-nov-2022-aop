package miu.edu.ea_day3_crudwithdb.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
//entity for testing composite key
@Entity
public class Employee {
    @EmbeddedId
    private EmployeeId id;
    private int salary;
    private String address;
}
