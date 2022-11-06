package miu.edu.ealab4aop.service.impl;

import miu.edu.ealab4aop.entity.Professor;
import miu.edu.ealab4aop.repository.ProfessorRepo;
import miu.edu.ealab4aop.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService {
    @Autowired
    private ProfessorRepo repo;

    @Override
    public List<Professor> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Professor> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Professor saveProfessor(Professor professor) {
        return repo.save(professor);
    }


    @Override
    public Professor updateProfessor(Professor course) {
        return repo.save(course);
    }

    @Override
    public void deleteProfessorById(Long id) {
        repo.deleteById(id);
    }

}
