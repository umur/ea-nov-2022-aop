package miu.edu.ealab4aop.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private Long credit;

    @OneToMany(mappedBy = "course")
    List<CourseStudent> courseStudents;

    @OneToMany(mappedBy = "course")
    List<Course_Professor> course_professors;
}
