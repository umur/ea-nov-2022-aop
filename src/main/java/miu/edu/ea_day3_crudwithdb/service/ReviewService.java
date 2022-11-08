package miu.edu.ea_day3_crudwithdb.service;

import miu.edu.ea_day3_crudwithdb.DTO.ReviewDto;
import miu.edu.ea_day3_crudwithdb.DTO.UserDto;

import java.util.List;

public interface ReviewService {

    void save(ReviewDto review);

    void delete(int id);

    ReviewDto getById(int id);

    List<ReviewDto> getAll();

    void update(int id, ReviewDto review);
}
