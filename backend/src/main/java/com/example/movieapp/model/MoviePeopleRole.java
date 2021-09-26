package com.example.movieapp.model;

import javax.persistence.*;

@Entity
@Table(name = "movie_people_role")
public class MoviePeopleRole {

    @EmbeddedId
    @Column(name = "movie_people_role_id")
    MoviePeopleRoleId moviePeopleRoleId;

    @ManyToOne
    @MapsId("moviePeopleId")
    @JoinColumn(name = "moviePeopleId", nullable = false)
    private MoviePeople moviePeople;

    @ManyToOne
    @MapsId("movieRoleId")
    @JoinColumn(name = "movieRoleId", nullable = false)
    private MovieRole movieRole;


}
