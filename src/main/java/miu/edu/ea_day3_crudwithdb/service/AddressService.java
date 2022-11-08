package miu.edu.ea_day3_crudwithdb.service;

import miu.edu.ea_day3_crudwithdb.DTO.AddressDto;

import java.util.List;

public interface AddressService {

    void save(AddressDto address);

    void delete(int id);

    AddressDto getById(int id);

    List<AddressDto> getAll();

    void update(int id, AddressDto address);
}
