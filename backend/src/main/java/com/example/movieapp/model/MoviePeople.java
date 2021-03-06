package com.example.movieapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="movie_people")
public class MoviePeople {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer moviePeopleId;

    @Column(name = "firstName",nullable = false)
    private String firstName;

    @Column(name = "lastName",nullable = false)
    private String lastName;

    @Column(name = "birthDate",nullable = false)
    private Date birthDate;

    @Column(name = "gender",nullable = false)
    private String gender;
}
