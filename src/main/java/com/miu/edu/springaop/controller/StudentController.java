package com.miu.edu.springaop.controller;

import com.miu.edu.springaop.aop.annotation.ExecutionTime;
import com.miu.edu.springaop.entity.Student;
import com.miu.edu.springaop.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    @GetMapping("/status")
    public String status(){
        return "API is up and running.";
    }

    @GetMapping
    @ExecutionTime
    public List<Student> getAllStudent(){
       return studentService.getAllStudents();
    }

    @PostMapping
    public void addStudent(@RequestBody Student student){
        System.out.println("inside the add request..");
    }
}
