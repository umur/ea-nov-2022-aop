package miu.edu.ealab4aop.service;

import miu.edu.ealab4aop.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> findAll();
    Optional<Student> findById(Long id);
    Student saveStudent(Student professor);
    Student updateStudent(Student professor);
    void deleteStudentById(Long id);
}
