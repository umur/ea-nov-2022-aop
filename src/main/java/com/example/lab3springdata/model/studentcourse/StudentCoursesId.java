package com.example.lab3springdata.model.studentcourse;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@SuppressWarnings("unused")
public class StudentCoursesId implements Serializable {
    private String studentId;
    private String courseId;
}
