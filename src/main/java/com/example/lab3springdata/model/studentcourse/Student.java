package com.example.lab3springdata.model.studentcourse;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Student {

    @Id
    private int id;
    private String fName;
    private String lName;
    private String major;

    @OneToMany(mappedBy = "student")
    List<StudentsCourses> coursesTaken;
}
