package com.example.movieapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name="faculty")
public class Faculty {

    @Id
    @Column(unique = true, name="faculty_id", nullable = false)
    private String facultyId;

    @Column(name="name")
    private String name;

    public String getFacultyId() {
        return facultyId;
    }

   public void setFacultyId() {
        this.facultyId = UUID.randomUUID().toString().toUpperCase();
   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
