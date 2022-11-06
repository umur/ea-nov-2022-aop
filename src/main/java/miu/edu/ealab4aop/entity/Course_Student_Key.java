package miu.edu.ealab4aop.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Course_Student_Key implements Serializable {

    private Long studentId;
    private Long courseId;
}
