package com.AssignmentThree.Reposotory;

import com.AssignmentThree.Entities.Products;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Products, Integer> {
}
