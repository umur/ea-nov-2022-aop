package edu.miu.aop.aop.dto;

import lombok.Data;

/**
 * Author: Kuylim TITH
 * Date: 11/3/2022
 */
@Data
public class RequestProductDTO {
    private String name;

    private Double price;
    private Integer rating;
    private Long categoryId;
}
