package com.example.lab3springdata.controller;


import com.example.lab3springdata.aspect.ExecutionTime;
import com.example.lab3springdata.dto.ReviewDTO;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.lab3springdata.service.ReviewService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    private final ModelMapper modelMapper;

    public ReviewController(ReviewService reviewService, ModelMapper modelMapper) {
        this.reviewService = reviewService;
        this.modelMapper = modelMapper;
    }




    @GetMapping("/filter")
    @ExecutionTime
    public List<ReviewDTO> getAllReviewsByProductId(@RequestParam int byProduct) {

        return reviewService.getReviewsByProductId(byProduct)
                .stream()
                .map(p -> modelMapper.map(p, ReviewDTO.class))
                .collect(Collectors.toList());
    }









}
