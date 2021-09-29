package com.example.movieapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movie_people_role")
public class MoviePeopleRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer moviePeopleRoleId;

    @ManyToOne
    @JoinColumn(name = "movie_people_id", nullable = false)
    private MoviePeople moviePeople;

    @ManyToOne
    @JoinColumn(name = "movie_role_id", nullable = false)
    private MovieRole movieRole;


}
