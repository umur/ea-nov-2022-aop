package miu.edu.ea_day3_crudwithdb.DTO;

import lombok.Data;

@Data
public class ProductDto {
    private int id;
    private String name;
    private double price;
    private double rating;
}
