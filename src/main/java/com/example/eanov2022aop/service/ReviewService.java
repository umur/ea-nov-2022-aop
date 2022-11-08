package com.example.eanov2022aop.service;


import com.example.eanov2022aop.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    public List <ReviewDto> findAll ();

    public ReviewDto findReviewById (Integer id);

    void create (ReviewDto reviewDto);

    void delete (Integer id);

    void update(Integer id,String comment);

    List<ReviewDto> findByProduct_Id(Integer id);
}
