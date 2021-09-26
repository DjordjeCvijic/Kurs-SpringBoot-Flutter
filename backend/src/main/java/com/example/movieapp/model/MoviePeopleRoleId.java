package com.example.movieapp.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MoviePeopleRoleId implements Serializable {
    @Column(name = "movie_people_id")
    private Integer moviePeopleId;

    @Column(name = "movie_role_id")
    private Integer movieRoleId;
}
