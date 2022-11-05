package edu.miu.service.AOP.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class ActivityLog {

    @Id
    private int id;
    private  String executionTime;
    private String opration;
    private double duration;
}
