package com.example.movieapp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "stud_subject")
public class StudentSubject {
    //@Id
    //@GeneratedValue(strategy =GenerationType.IDENTITY)
    //private Integer SSid;

    @EmbeddedId
    @Column(name = "student_subject_id")
    StudentSubjectId studentSubjectId;


    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name="student_id", nullable = false)
    private Student student;


    @ManyToOne
    @MapsId("subjectId")
    @JoinColumn(name="subject_id", nullable = false)
    private Subject subject;

    private Integer rating;
}
