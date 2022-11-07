package edu.miu.springdata.repository;

import edu.miu.springdata.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends CrudRepository<Address, Long> {


}
