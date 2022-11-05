package labs.lab5.Service;

import labs.lab5.Entity.UniAddress;
import labs.lab5.Repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    public List<UniAddress> getAddresses(){
        return this.addressRepository.findAll();
    }

    public UniAddress getAddressById(String id){
        return this.addressRepository.findById(id).orElse(null);
    }

    public UniAddress saveAddress(UniAddress c){
        return this.addressRepository.save(c);
    }

    public void deleteAddressById(String id){
        this.addressRepository.deleteById(id);
    }
}
