package com.example.movieapp.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class StudentSubjectId implements Serializable {

    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "subject_id")
    private Integer subjectId;
}
