package com.aop.springaop.springdatabidirectional.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityLogDTO {
    private int id;
    private LocalDate date;
    private String operation;
    private double duration;
}
