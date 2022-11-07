package edu.miu.springdata.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity (name = "tbl_review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fld_review_id")
    private Long id;

    @Column(name = "fld_comment", nullable = false)
    private String comment;

}
