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
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String gender;
}
