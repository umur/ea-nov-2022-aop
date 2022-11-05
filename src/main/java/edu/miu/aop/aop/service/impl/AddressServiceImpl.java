package edu.miu.aop.aop.service.impl;

import edu.miu.aop.aop.dto.RequestAddressDTO;
import edu.miu.aop.aop.entity.Address;
import edu.miu.aop.aop.repository.AddressRepository;
import edu.miu.aop.aop.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Author: Kuylim TITH
 * Date: 11/3/2022
 */
@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;

    @Override
    public RequestAddressDTO save(RequestAddressDTO address) {
        Address a = new Address();
        BeanUtils.copyProperties(address, a);
        repository.save(a);
        return address;
    }

    @Override
    public RequestAddressDTO update(Long id, RequestAddressDTO address) {
        Optional<Address> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new RuntimeException("Address not found!");
        }
        Address a = optional.get();
        BeanUtils.copyProperties(address, a, "id");
        repository.save(a);
        return address;
    }

    @Override
    public List<Address> getAllAddress() {
        return repository.findAll();
    }

    @Override
    public Boolean deleteAddress(Long id) {
        repository.deleteById(id);
        return true;
    }
}
