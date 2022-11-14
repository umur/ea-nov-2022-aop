package com.example.aop.Controller;

//import com.example.day5.Aspect.annotation.ActivityLogging;
import com.example.aop.Aspect.annotation.ExecutionTime;
import com.example.aop.Service.StudentService;
import com.example.aop.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @ExecutionTime
    @GetMapping
    public List<Student> findAll(){
        return studentService.findAll();
    }
    @ExecutionTime
    @PostMapping
    public void save(@RequestBody Student student){
        studentService.save(student);
    }

    @ExecutionTime
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        studentService.delete(id);
    }

    @ExecutionTime
    @PutMapping
    public void update(@RequestBody Student student){
        studentService.update(student);
    }

}
