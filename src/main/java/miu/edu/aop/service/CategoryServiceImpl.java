package miu.edu.aop.service;

import lombok.RequiredArgsConstructor;
import miu.edu.aop.dto.CategoryDTO;
import miu.edu.aop.model.Category;
import miu.edu.aop.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;
    static ModelMapper mapper = new ModelMapper();
    private static final Function<Category, CategoryDTO> toDTO = item -> mapper.map(item, CategoryDTO.class);
    private static final Function<CategoryDTO, Category> toEntity = item -> mapper.map(item, Category.class);

    public List<CategoryDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(toDTO)
                .collect(Collectors.toList());
    }

    public Optional<CategoryDTO> findOne(Long id) {
        return repository.findById(id)
                .map(toDTO);
    }

    public CategoryDTO save(CategoryDTO product) {
        return toDTO.apply(toEntity.apply(product));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
