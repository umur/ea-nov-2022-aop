package miu.edu.ealab4aop.repository;

import miu.edu.ealab4aop.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepo extends JpaRepository<Professor,Long> {
}
