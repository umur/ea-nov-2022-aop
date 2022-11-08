package com.example.productreview.entity.uni_and_bi_directional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String comment;
    @ManyToOne
    @JsonIgnore
    private Product product;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User_ user_;
}
