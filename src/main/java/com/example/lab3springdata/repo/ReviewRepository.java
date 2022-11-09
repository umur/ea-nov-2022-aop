package com.example.lab3springdata.repo;

import com.example.lab3springdata.model.uni_directional.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ReviewRepository extends CrudRepository<Review,Integer> {

    List<Review> findAllByProduct_Id(int id);

    // implement using JPQL

//    @Query("SELECT reviews as r from where r.id='' ")
    List<Review> findByWhatIWant(int id);


}
