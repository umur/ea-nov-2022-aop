package com.example.eanov2022springdataI.repository;

import com.example.eanov2022springdataI.entity.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ReviewRepository extends CrudRepositoryInterface<Review>{

    @Query("select r from Review r where r.user.id = :id")
    List<Review> findAllByUserId(String id);

}
