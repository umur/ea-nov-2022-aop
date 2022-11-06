package miu.edu.ealab4aop.controller;

import miu.edu.ealab4aop.aspect.ExecutionTimeAspect;
import miu.edu.ealab4aop.entity.Course;
import miu.edu.ealab4aop.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService service;

    @GetMapping
    @ExecutionTimeAspect
    public ResponseEntity<List<Course>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }
    
    @ExecutionTimeAspect
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Course>> findById(@PathVariable Long id) {
        return  ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @ExecutionTimeAspect
    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        return ResponseEntity.status(HttpStatus.OK).body(service.addCourse(course));
    }

    @ExecutionTimeAspect
    @PutMapping
    public ResponseEntity<Course> updateCourse(@RequestBody Course course) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateCourse(course));
    }

    @ExecutionTimeAspect
    @DeleteMapping("/{id}")
    public void deleteCourseById(@PathVariable Long id) {
        service.deleteById(id);
    }
    
}
