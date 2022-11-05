package labs.lab5.Repository;

import labs.lab5.Entity.UniUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UniUser, String> {
    List<UniUser> findAll();
}
