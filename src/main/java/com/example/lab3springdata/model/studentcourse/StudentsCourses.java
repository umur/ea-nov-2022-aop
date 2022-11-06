package com.example.lab3springdata.model.studentcourse;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.util.Date;

@Data
@Entity
public class StudentsCourses {

    @EmbeddedId
    private StudentCoursesId id;
    private Date courseTakenDate;
    private String assignedRoom;

    @ManyToOne
    @MapsId("studentId")
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    private Course course;
}
