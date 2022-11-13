package com.miu.edu.aop.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.miu.edu.aop.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

    private int id;

    private String street;

    private String zip;

    private String city;

    @JsonIgnore
    private UserDto userDto;
    public static AddressDto convertFrom(Address address) {
        if (address == null) {
            return null;
        }
        return new AddressDto(
                address.getId(),
                address.getStreet(),
                address.getZip(),
                address.getCity(),
                null
        );
    }

    public static Address convertTo(AddressDto address) {
        if (address == null) {
            return null;
        }
        return new Address(
                address.getId(),
                address.getStreet(),
                address.getZip(),
                address.getCity(),
                UserDto.convertTo(address.getUserDto())
        );
    }
}
