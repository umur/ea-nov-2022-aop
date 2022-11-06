package miu.edu.ealab4aop.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Course_Professor {

    @EmbeddedId
    private Course_Professor_Key course_professor_key;

    @ManyToOne
    @MapsId("courseId")
    private Course course;

    @ManyToOne
    @MapsId("professorId")
    private Professor professor;
}
