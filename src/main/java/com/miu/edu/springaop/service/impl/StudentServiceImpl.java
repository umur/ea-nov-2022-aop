package com.miu.edu.springaop.service.impl;

import com.miu.edu.springaop.entity.Student;
import com.miu.edu.springaop.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {


    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        Student larry = new Student(1L, "Larry Dakota", "larry@miu.edu", "778977","MSCS");
        Student harry = new Student(1L, "Harry Wallace", "harry@miu.edu", "8099957","MSCS");
        students.add(larry);
        students.add(harry);
        return students;
    }
}
