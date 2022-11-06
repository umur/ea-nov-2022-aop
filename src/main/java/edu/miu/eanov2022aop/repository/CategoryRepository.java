package edu.miu.eanov2022aop.repository;

import edu.miu.eanov2022aop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAll();

    Category getReferenceById(Long id);
}
