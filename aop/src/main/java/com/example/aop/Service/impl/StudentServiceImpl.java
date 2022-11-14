package com.example.aop.Service.impl;

import com.example.aop.Repository.StudentRepo;
import com.example.aop.Service.StudentService;
import com.example.aop.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public void save(Student student) {
        studentRepo.save(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public void delete(int id) {
        studentRepo.deleteById(id);
    }

    @Override
    public void update(Student student) {
        studentRepo.save(student);
    }
}
