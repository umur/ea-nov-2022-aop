package com.example.lab3springdata.service;

import com.example.lab3springdata.model.Product;
import com.example.lab3springdata.model.dto.ProductDTO;
import com.example.lab3springdata.repository.ProductRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class ProductServiceImpl implements IProductService {

    private final ProductRepo productRepo;
    private final ModelMapper modelMapper = new ModelMapper();
    private final Function<Product, ProductDTO> dtoMapper = product -> this.modelMapper.map(product, ProductDTO.class);
    private final Function<ProductDTO, Product> productMapper = productDTO -> this.modelMapper.map(productDTO, Product.class);

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
        this.modelMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    @Override
    public List<ProductDTO> findProductsByPrice(double minPrice) {
        List<Product> products = productRepo.findProductsByPriceGreaterThan(minPrice);
        return products
                .stream()
                .map(dtoMapper)
                .toList();
    }
    @Override
    public List<ProductDTO> findProductsByCategory_NameAndPriceLessThan(String category_name, double price){
        List<Product> products = productRepo.findProductsByCategory_NameAndPriceLessThan(category_name, price);
        return products
                .stream()
                .map(dtoMapper)
                .toList();
    }

    @Override
    public List<ProductDTO> findAllByNameContaining(String filterText){
        List<Product> products = productRepo.findAllByNameContaining(filterText);
        return products
                .stream()
                .map(dtoMapper)
                .toList();
    }

    @Override
    public ProductDTO getProductById(int id) {
        Product product = productRepo.findProductsById(id);
        return dtoMapper.apply(product);
    }

    @Override
    public void addProduct(ProductDTO productDTO) {
        Product product = productMapper.apply(productDTO);
        productRepo.save(product);
    }
}
