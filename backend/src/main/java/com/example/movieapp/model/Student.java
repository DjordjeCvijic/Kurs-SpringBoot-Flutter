package com.example.movieapp.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //nacin na koji se generise
    private Integer studentId;

    private String name;
    private Integer yearOfStudy;
    private String faculty;
    @ManyToOne
    @JoinColumn(name="cityId", nullable = false)
    private City cityId;

    @ManyToMany
    @JoinTable(
            name="student_subject",
            joinColumns = @JoinColumn(name="student_id"),
            inverseJoinColumns = @JoinColumn(name="subject_id")
    )
    private Set<Subject> subject;
}
