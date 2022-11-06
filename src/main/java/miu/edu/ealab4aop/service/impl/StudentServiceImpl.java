package miu.edu.ealab4aop.service.impl;

import miu.edu.ealab4aop.entity.Student;
import miu.edu.ealab4aop.repository.StudentRepo;
import miu.edu.ealab4aop.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo repo;

    @Override
    public List<Student> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Student saveStudent(Student student) {
        return repo.save(student);
    }

    @Override
    public Student updateStudent(Student course) {
        return repo.save(course);
    }

    @Override
    public void deleteStudentById(Long id) {
        repo.deleteById(id);
    }

}
