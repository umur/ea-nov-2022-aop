package edu.miu.aop.aop.repository;

import edu.miu.aop.aop.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Kuylim TITH
 * Date: 11/3/2022
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
