package miu.edu.ealab4aop.service;

import miu.edu.ealab4aop.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> findAll();
    Optional<Course> findById(Long id);
    Course addCourse(Course course);
    Course updateCourse(Course course);
    void deleteById(Long id);
}
