package com.example.lab3springdata.controller;


import com.example.lab3springdata.dto.ProductDTO;
import com.example.lab3springdata.model.uni_directional.Product;
import com.example.lab3springdata.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
@Configuration
public class ProductController {
//
//    List<Product> findAllByPriceGreaterThan(double price);
//
//    List<Product> findAllByCategory_NameAndPriceIsLessThan(String name, double price);
//
//    List<Product> findAllByNameContaining(String name);

    private final ModelMapper modelMapper;


    private final ProductService productService;

    public ProductController(ModelMapper modelMapper, ProductService productService) {
        this.modelMapper = modelMapper;
        this.productService = productService;
    }

    @PostMapping
    public void createP(@RequestBody ProductDTO productDTO) {
        Product mappedProduct = modelMapper.map(productDTO, Product.class);
        productService.create(mappedProduct);

    }


    @GetMapping("/filter")
    List <ProductDTO> filterBy(@RequestParam(required = false) Double price_gt, @RequestParam(required = false) String name) {

        Double filteredPrice = null;
        String filteredName = null;

        if(price_gt != null) {
            filteredPrice = price_gt;
        }
        else if (name!= null) {
            filteredName = name;
        }

        if (filteredPrice!=null) return productService
                .findAllByPriceGreaterThan(price_gt)
                 .stream()
                .map(p -> modelMapper.map(p, ProductDTO.class))
                .collect(Collectors.toList());

        else if (filteredName!=null) {
            return productService
                    .findAllByNameContaining(name)
                    .stream()
                    .map(p -> modelMapper.map(p, ProductDTO.class))
                    .collect(Collectors.toList());
        }

        return null;
    }

    @GetMapping("/filterby")
    List<ProductDTO> filterByCategoryAndPrice(@RequestParam String catName, @RequestParam double price) {
        return productService
                .findAllByCategory_NameAndPriceIsLessThan(catName, price)
                .stream()
                .map(p -> modelMapper.map(p, ProductDTO.class))
                .collect(Collectors.toList());
    }
}
