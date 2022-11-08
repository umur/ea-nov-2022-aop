package com.example.eanov2022aop.service.Impl;


import com.example.eanov2022aop.dto.AddressDto;
import com.example.eanov2022aop.entity.Address;
import com.example.eanov2022aop.mapper.AddressMapper;
import com.example.eanov2022aop.repository.AddressRepo;
import com.example.eanov2022aop.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressRepo addressRepo;
    private final AddressMapper addressMapper;

    @Transactional
    @Override
    public List <AddressDto> findAll () {
        return addressMapper.toDtos ((List <Address>) addressRepo.findAll ());
    }
    @Transactional
    @Override
    public  AddressDto findAddressById (Integer id) {
        return addressMapper.toDto (addressRepo.findAddressById (id));
    }

    @Transactional
    @Override
    public void create (AddressDto addressDto) {
        addressRepo.save (addressMapper.toEntity (addressDto));

    }

    @Override
    public void delete (Integer id) {
        boolean exists = addressRepo.existsById (id);
        if(!exists){
            throw new IllegalStateException ("Address id:"+id+"does not exist");
        }
        addressRepo.deleteById (id);

    }

    @Override
    @Transactional
    public void update(Integer id,String street,String zipcode,String city) {
        Address address = addressRepo.findById (id)
                .orElseThrow (()->new IllegalStateException (
                        "Address id:"+id+"does not exist"));

        if(street !=null &&street.length ()>0 ){
            address.setStreet (street);
        }
        if(zipcode !=null &&zipcode.length ()>0 ){
            address.setZip (zipcode);
        }
        if(city !=null &&city.length ()>0 ){
            address.setCity (city);
        }
    }
}
