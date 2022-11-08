package miu.edu.ea_day3_crudwithdb.repository;

import miu.edu.ea_day3_crudwithdb.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
}
