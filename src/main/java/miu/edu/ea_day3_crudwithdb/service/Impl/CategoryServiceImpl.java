package miu.edu.ea_day3_crudwithdb.service.Impl;

import lombok.RequiredArgsConstructor;
import miu.edu.ea_day3_crudwithdb.DTO.CategoryDto;
import miu.edu.ea_day3_crudwithdb.DTO.ProductDto;
import miu.edu.ea_day3_crudwithdb.DTO.UserDto;
import miu.edu.ea_day3_crudwithdb.entity.Category;
import miu.edu.ea_day3_crudwithdb.entity.Product;
import miu.edu.ea_day3_crudwithdb.repository.CategoryRepo;
import miu.edu.ea_day3_crudwithdb.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;
    private final ModelMapper mapper;

    @Override
    public void save(CategoryDto category) {
        var entity = mapper.map(category, Category.class);
        categoryRepo.save(entity);
    }

    @Override
    public void delete(int id) {
        categoryRepo.deleteById(id);
    }

    @Override
    public CategoryDto getById(int id) {
        var entity = categoryRepo.findById(id).get();
        var entityDto = mapper.map(entity, CategoryDto.class);
        return entityDto;
    }

    @Override
    public List<CategoryDto> getAll() {
        List<CategoryDto> result = StreamSupport
                .stream(categoryRepo.findAll().spliterator(), false)
                .map(c -> mapper.map(c, CategoryDto.class))
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public void update(int id, CategoryDto category) {
        var existingCategory = categoryRepo.findById(id).get();
        if (existingCategory!= null){
            existingCategory.setName(category.getName());
            categoryRepo.save(existingCategory);
        }
    }

    @Override
    public List<ProductDto> getProductsByCategoryAndCostLessThanMaxPrice(String category, double maxPrice) {
       Stream<Product> productStream = categoryRepo.findAllByNameContaining(category).stream()
               .flatMap(cat-> cat.getProducts().stream());
       List<ProductDto> productDto = productStream.filter(p-> p.getPrice() < maxPrice)
               .map(p-> mapper.map(p, ProductDto.class))
               .collect(Collectors.toList());
       return productDto;
    }
}
