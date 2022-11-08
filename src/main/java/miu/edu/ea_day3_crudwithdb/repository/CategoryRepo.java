package miu.edu.ea_day3_crudwithdb.repository;

import miu.edu.ea_day3_crudwithdb.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Integer> {
    List<Category> findAllByNameContaining(String name);
}
