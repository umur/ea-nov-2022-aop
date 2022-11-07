package edu.miu.springdata.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity(name = "tbl_activity_log")
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fld_activity_log_id")
    private Long id;

    @Column(name = "fld_date_time")
    private LocalDateTime dateTime;

    @Column(name = "fld_operation")
    private String operation;

    @Column(name = "fld_duration")
    private Long duration;
}
