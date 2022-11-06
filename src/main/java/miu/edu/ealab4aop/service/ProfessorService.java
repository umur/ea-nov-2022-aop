package miu.edu.ealab4aop.service;

import miu.edu.ealab4aop.entity.Professor;

import java.util.List;
import java.util.Optional;

public interface ProfessorService {
    List<Professor> findAll();
    Optional<Professor> findById(Long id);
    Professor saveProfessor(Professor professor);
    Professor updateProfessor(Professor professor);
    void deleteProfessorById(Long id);
}
