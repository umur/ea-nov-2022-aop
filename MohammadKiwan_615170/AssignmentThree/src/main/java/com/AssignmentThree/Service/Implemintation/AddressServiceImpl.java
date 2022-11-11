package com.AssignmentThree.Service.Implemintation;

import com.AssignmentThree.Entities.Addresses;
import com.AssignmentThree.Reposotory.AddressRepo;
import com.AssignmentThree.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepo addressRepo;

    @Override
    public void add(Addresses addresses){
        addressRepo.save(addresses);
    }

    public List<Addresses> getAll(){
        return  addressRepo.findAll();
    }

    public void delete(int addressId){
        addressRepo.deleteById(addressId);
    }

//    public void update (Addresses address){
//        addressRepo.save(address);
//    }

}
