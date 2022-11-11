package com.AssignmentThree.Reposotory;

import com.AssignmentThree.Entities.Reviews;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepo extends CrudRepository<Reviews, Integer> {
}
