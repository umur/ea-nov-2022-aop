package com.example.lab3springdata.repo;

import com.example.lab3springdata.model.uni_directional.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ReviewRepository extends CrudRepository<Review,Integer> {

    List<Review> findAllByProduct_Id(int id);

}
