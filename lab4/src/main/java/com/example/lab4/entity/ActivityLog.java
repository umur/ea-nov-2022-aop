package com.example.lab4.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityLog {
    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY)
    private Long id;
    private String date;
    private String operation;
    private long duration;
}



