package miu.edu.ea_day3_crudwithdb.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

//testing composite key
@Embeddable
@Data
public class EmployeeId implements Serializable {
    private String fname;
    private String lname;
}
