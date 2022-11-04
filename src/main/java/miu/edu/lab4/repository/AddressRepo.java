package miu.edu.lab4.repository;

import miu.edu.lab4.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends CrudRepository<Address, Integer> {

}
