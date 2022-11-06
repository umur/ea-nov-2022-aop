package com.AssignmentThree.Entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    LocalDate data;
    String operation;
    double durationInSeconds;
}
