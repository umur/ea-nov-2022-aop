package com.example.Product.Review.repo;

import com.example.Product.Review.entities.join_column.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends CrudRepository<Address, Long> {
}
