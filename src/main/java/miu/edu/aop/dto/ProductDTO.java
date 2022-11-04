package miu.edu.aop.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private Double price;
    private Double rating;
}
