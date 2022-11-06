package com.example.lab3springdata.model.studentcourse;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Course {
    @Id
    private int id;
    private String courseCode;

    @OneToMany(mappedBy = "course")
    List<StudentsCourses> coursesTaken;
}
