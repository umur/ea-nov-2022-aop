package labs.lab5.Repository;

import labs.lab5.Entity.UniAddress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<UniAddress, String> {
    List<UniAddress> findAll();
}
