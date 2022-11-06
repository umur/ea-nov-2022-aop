package miu.edu.ealab4aop.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Course_Professor_Key implements Serializable {

    private Long professorId;
    private Long courseId;
}
