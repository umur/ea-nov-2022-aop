package miu.edu.ealab4aop.service.impl;

import miu.edu.ealab4aop.entity.Course;
import miu.edu.ealab4aop.repository.CourseRepo;
import miu.edu.ealab4aop.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepo repo;

    @Override
    public List<Course> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Course> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Course addCourse(Course course) {
        return repo.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return repo.save(course);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
