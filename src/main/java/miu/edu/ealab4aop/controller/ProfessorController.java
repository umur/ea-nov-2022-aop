package miu.edu.ealab4aop.controller;

import miu.edu.ealab4aop.aspect.ExecutionTimeAspect;
import miu.edu.ealab4aop.entity.Professor;
import miu.edu.ealab4aop.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professors")
public class ProfessorController {
    @Autowired
    private ProfessorService service;

    @GetMapping
    @ExecutionTimeAspect
    public ResponseEntity<List<Professor>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }
    
    @ExecutionTimeAspect
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Professor>> findById(@PathVariable Long id) {
        return  ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @ExecutionTimeAspect
    @PostMapping
    public ResponseEntity<Professor> addProfessor(Professor course) {
        return ResponseEntity.status(HttpStatus.OK).body(service.saveProfessor(course));
    }

    @ExecutionTimeAspect
    @PutMapping
    public ResponseEntity<Professor> updateProfessor(Professor student) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateProfessor(student));
    }

    @ExecutionTimeAspect
    @DeleteMapping("/{id}")
    public void deleteProfessorById(@PathVariable Long id) {
        service.deleteProfessorById(id);
    }
    
}
