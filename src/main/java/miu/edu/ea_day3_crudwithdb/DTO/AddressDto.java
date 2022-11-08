package miu.edu.ea_day3_crudwithdb.DTO;


import lombok.Data;

@Data
public class AddressDto {
    private String street;
    private String zip;
    private String city;
}
