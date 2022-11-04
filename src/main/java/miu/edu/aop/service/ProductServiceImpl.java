package miu.edu.aop.service;

import lombok.RequiredArgsConstructor;
import miu.edu.aop.dto.ProductDTO;
import miu.edu.aop.model.Category;
import miu.edu.aop.model.Product;
import miu.edu.aop.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    static ModelMapper mapper = new ModelMapper();
    private static final Function<Product, ProductDTO> toDTO = item -> mapper.map(item, ProductDTO.class);
    private static final Function<ProductDTO, Product> toEntity = item -> mapper.map(item, Product.class);

    public List<ProductDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ProductDTO> findOne(Long id) {
        return repository.findById(id)
                .map(toDTO);
    }

    public ProductDTO save(ProductDTO product) {
        return toDTO.apply(toEntity.apply(product));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<ProductDTO> findAllWithMinPrice(Double price) {
        return repository.findAllByPriceGreaterThanEqual(price)
                .stream()
                .map(toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findAllWithCategoryAndMaxPrice(Category category, Double price) {
        return repository.findAllByCategoryAndPriceLessThanEqual(category, price)
                .stream()
                .map(toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findAllWithNameContains(String term) {
        return repository.findAllByNameContains(term)
                .stream()
                .map(toDTO)
                .collect(Collectors.toList());
    }
}
