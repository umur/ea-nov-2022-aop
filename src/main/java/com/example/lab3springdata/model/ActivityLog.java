package com.example.lab3springdata.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


@Data
@Entity
@RequiredArgsConstructor
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @NonNull
    private LocalDate date;

    @NonNull
    private String operation;

    @NonNull
    private double duration;

    public ActivityLog() {

    }
}
