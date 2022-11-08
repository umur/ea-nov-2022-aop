package com.example.eanov2022aop.mapper;


import com.example.eanov2022aop.dto.ProductDto;
import com.example.eanov2022aop.entity.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class ProductMapper {
    private final ModelMapper modelMapper;

    public ProductDto toDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }

    public List <ProductDto> toDtos(List<Product> products) {
        return products.stream()
                .map(this::toDto)
                .toList();
    }

    public Product toEntity(ProductDto productDto) {
        return modelMapper.map(productDto, Product.class);
    }

    public List<Product> toEntities(List<ProductDto> productDtos) {
        return productDtos.stream()
                .map(this::toEntity)
                .toList();
    }
}
