package miu.edu.ealab4aop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("2")
public class Student extends Person{

    private double gpa;

    @OneToMany(mappedBy = "student")
    private List<CourseStudent> courseStudents;

    @OneToMany(mappedBy = "student")
    private List<Professor_Student> professor_students;
}
