package miu.edu.aop.service;

import lombok.RequiredArgsConstructor;
import miu.edu.aop.dto.ReviewDTO;
import miu.edu.aop.model.Review;
import miu.edu.aop.repository.ReviewRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository repository;
    static ModelMapper mapper = new ModelMapper();
    private static final Function<Review, ReviewDTO> toDTO = item -> mapper.map(item, ReviewDTO.class);
    private static final Function<ReviewDTO, Review> toEntity = item -> mapper.map(item, Review.class);

    public List<ReviewDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ReviewDTO> findOne(Long id) {
        return repository.findById(id)
                .map(toDTO);
    }

    public ReviewDTO save(ReviewDTO product) {
        return toDTO.apply(toEntity.apply(product));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<ReviewDTO> findAllReviewByProductId(Long id) {
        return repository.findAllByUserId(id)
                .stream()
                .map(toDTO)
                .collect(Collectors.toList());
    }
}
