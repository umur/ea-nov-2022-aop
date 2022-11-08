package com.example.productreview.entity.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ActivityLogDTO {
    private long Id;
    private LocalDate date = LocalDate.now();
    private String operation;
    private Long duration;
}
