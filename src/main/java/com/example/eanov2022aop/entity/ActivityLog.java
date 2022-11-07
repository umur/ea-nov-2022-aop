package com.example.eanov2022aop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityLog implements Identifiable{

    @Id
    String id;

    Date date;
    String operation;
    long duration;

}
