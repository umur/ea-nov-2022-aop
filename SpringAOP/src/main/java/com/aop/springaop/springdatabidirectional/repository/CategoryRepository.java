package com.aop.springaop.springdatabidirectional.repository;

import com.aop.springaop.springdatabidirectional.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {
}
