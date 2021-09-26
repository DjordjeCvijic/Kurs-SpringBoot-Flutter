package com.example.movieapp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "movie_cast")
public class MovieCast implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieCastId;

    @ManyToOne
    @JoinColumn(name = "contentId", nullable = false)
    private Content contentId;

    @ManyToOne
    @JoinColumn(name = "moviePeopleId",
            nullable = false)
    private MoviePeople moviePeopleId;

    @ManyToOne
    @JoinColumn(name = "movieRoleId", nullable = false)
    private MovieRole movieRoleId;

}
