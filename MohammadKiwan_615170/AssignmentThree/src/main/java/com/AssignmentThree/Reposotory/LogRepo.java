package com.AssignmentThree.Reposotory;

import com.AssignmentThree.Entities.Log;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepo  extends CrudRepository<Log, Integer> {
}
