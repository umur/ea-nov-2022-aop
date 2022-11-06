package miu.edu.ealab4aop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@DiscriminatorValue("1")
public class Professor extends Person {
    private double salary;

    @OneToMany(mappedBy = "professor")
    private List<Course_Professor> course_professors;

    @OneToMany(mappedBy = "professor")
    private List<Professor_Student> professor_students;
}
