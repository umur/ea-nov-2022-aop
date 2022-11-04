package miu.edu.lab4.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class ActivityLog {
   // id,date,operation,duration
    @Id
    private int id;
    private Date date;
    private String operation;
    private long duration;
}
