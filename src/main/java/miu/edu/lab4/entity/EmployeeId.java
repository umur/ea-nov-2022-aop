package miu.edu.lab4.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
@Data
public class EmployeeId  implements Serializable{
    private String fName;
    private String Lname;


}
