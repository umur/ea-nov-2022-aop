package com.example.eanov2022aop.mapper;


import com.example.eanov2022aop.dto.AddressDto;
import com.example.eanov2022aop.entity.Address;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor

public class AddressMapper {
    private final ModelMapper modelMapper;

    public AddressDto toDto(Address address) {
        return modelMapper.map(address, AddressDto.class);
    }

    public List <AddressDto> toDtos(List<Address> addresses) {
        return addresses.stream()
                .map(this::toDto)
                .toList();
    }

    public Address toEntity(AddressDto addressDto) {
        return modelMapper.map(addressDto, Address.class);
    }

    public List<Address> toEntities(List<AddressDto> addressDtos) {
        return addressDtos.stream()
                .map(this::toEntity)
                .toList();
    }
}
