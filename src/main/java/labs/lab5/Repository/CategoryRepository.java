package labs.lab5.Repository;

import labs.lab5.Entity.UniCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<UniCategory, String> {
    List<UniCategory> findAll();
}
