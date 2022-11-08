package miu.edu.ea_day3_crudwithdb.service.Impl;

import lombok.RequiredArgsConstructor;
import miu.edu.ea_day3_crudwithdb.DTO.AddressDto;
import miu.edu.ea_day3_crudwithdb.entity.Address;
import miu.edu.ea_day3_crudwithdb.repository.AddressRepository;
import miu.edu.ea_day3_crudwithdb.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final ModelMapper mapper;

    @Override
    public void save(AddressDto address) {
        addressRepository.save(mapper.map(address, Address.class));
    }

    @Override
    public void delete(int id) {
        addressRepository.deleteById(id);
    }

    @Override
    public AddressDto getById(int id) {
        var address = addressRepository.findById(id).get();
        var addDto = mapper.map(address, AddressDto.class);
        return addDto;
    }

    @Override
    public List<AddressDto> getAll() {
        Iterable<Address> addresses = addressRepository.findAll();
        List<AddressDto> result = StreamSupport.stream(addresses.spliterator(), false)
                .map(a -> mapper.map(a, AddressDto.class))
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public void update(int id, AddressDto address) {
        var existingEntity = addressRepository.findById(id).get();
        if (existingEntity != null) {
            existingEntity.setStreet(address.getStreet());
            existingEntity.setCity(address.getCity());
            existingEntity.setZip(address.getZip());
            addressRepository.save(existingEntity);
        }
    }
}
