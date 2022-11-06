package miu.edu.ealab4aop.controller;

import miu.edu.ealab4aop.aspect.ExecutionTimeAspect;
import miu.edu.ealab4aop.entity.Student;
import miu.edu.ealab4aop.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping
    @ExecutionTimeAspect
    public ResponseEntity<List<Student>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @ExecutionTimeAspect
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Student>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @ExecutionTimeAspect
    @PostMapping
    public ResponseEntity<Student> addStudent(Student course) {
        return ResponseEntity.status(HttpStatus.OK).body(service.saveStudent(course));
    }

    @ExecutionTimeAspect
    @PutMapping
    public ResponseEntity<Student> updateStudent(Student student) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateStudent(student));
    }

    @ExecutionTimeAspect
    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        service.deleteStudentById(id);
    }

}
