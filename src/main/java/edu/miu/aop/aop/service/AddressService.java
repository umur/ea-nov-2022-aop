package edu.miu.aop.aop.service;

import edu.miu.aop.aop.dto.RequestAddressDTO;
import edu.miu.aop.aop.entity.Address;

import java.util.List;

/**
 * Author: Kuylim TITH
 * Date: 11/3/2022
 */
public interface AddressService {

    RequestAddressDTO save(RequestAddressDTO address);

    RequestAddressDTO update(Long id, RequestAddressDTO address);

    List<Address> getAllAddress();

    Boolean deleteAddress(Long id);
}
