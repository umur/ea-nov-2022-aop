package com.example.springaop.entities.DTOs;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ActivityLogDTO {
    private int id;
    private LocalDate date;
    private String operation;
    private long duration;
}
