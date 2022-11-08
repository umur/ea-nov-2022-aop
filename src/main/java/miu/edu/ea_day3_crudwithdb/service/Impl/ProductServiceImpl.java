package miu.edu.ea_day3_crudwithdb.service.Impl;

import lombok.RequiredArgsConstructor;
import miu.edu.ea_day3_crudwithdb.DTO.ProductDto;
import miu.edu.ea_day3_crudwithdb.DTO.ReviewDto;
import miu.edu.ea_day3_crudwithdb.entity.Category;
import miu.edu.ea_day3_crudwithdb.entity.Product;
import miu.edu.ea_day3_crudwithdb.repository.CategoryRepo;
import miu.edu.ea_day3_crudwithdb.repository.ProductRepository;
import miu.edu.ea_day3_crudwithdb.service.CategoryService;
import miu.edu.ea_day3_crudwithdb.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper mapper;

    @Override
    public void save(ProductDto productDto) {
        var product = mapper.map(productDto, Product.class);
        productRepository.save(product);
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductDto getById(int id) {
        var entity = productRepository.findById(id).get();
        var dto = mapper.map(entity, ProductDto.class);
        return dto;
    }

    @Override
    public List<ProductDto> getAll() {
        List<ProductDto> products = StreamSupport.stream(productRepository.findAll().spliterator(), false)
                .map(p -> mapper.map(p, ProductDto.class))
                .collect(Collectors.toList());
        return products;
    }

    @Override
    public void update(int id, ProductDto product) {
        var existingProduct = productRepository.findById(id).get();
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setRating(product.getRating());
            productRepository.save(existingProduct);
        }
    }

    @Override
    public List<ProductDto> getProductsGreaterThanMinPrice(Double minPrice) {
        List<ProductDto> products = StreamSupport
                .stream(productRepository.findAllByPriceGreaterThan(minPrice).spliterator(), false)
                .map(p -> mapper.map(p, ProductDto.class))
                .collect(Collectors.toList());
        return products;
    }

    @Override
    public List<ProductDto> getProductsByName(String keyword) {
        List<ProductDto> products = StreamSupport
                .stream(productRepository.findAllByNameContaining(keyword).spliterator(), false)
                .map(p -> mapper.map(p, ProductDto.class))
                .collect(Collectors.toList());
        return products;
    }

    @Override
    public List<ReviewDto> getReviewByProductId(int productId) {
        List<ReviewDto> reviews = productRepository.findById(productId).stream()
                .flatMap(p -> p.getReviews().stream())
                .map(r -> mapper.map(r, ReviewDto.class))
                .collect(Collectors.toList());
        return reviews;
    }
}
