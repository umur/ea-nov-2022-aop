package com.example.aop.Service;

import com.example.aop.entity.Student;

import java.util.List;

public interface StudentService {

    public void save(Student student);

    public List<Student> findAll();

    public void delete(int id);

    public void update(Student student);
}
