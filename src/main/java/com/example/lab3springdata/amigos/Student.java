package com.example.lab3springdata.amigos;


import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

//@Entity
@Data
@RequiredArgsConstructor
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;

    @Column(
            name = "fist_name",
            columnDefinition = "TEXT",
            nullable = false
    )
    @NonNull
    private String firstName;


    @Column(
            name = "last_name",
            columnDefinition = "TEXT",
            nullable = false
    )
    @NonNull
    private String lastName;

    @Column(
            name = "email",
            columnDefinition = "TEXT",
            nullable = false,
            unique = true
    )
    @NonNull
    private String email;

    @Column(
            name = "age",
            nullable = false
    )
    @NonNull
    private int age;

}
