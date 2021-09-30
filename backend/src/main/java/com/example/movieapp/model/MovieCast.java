package com.example.movieapp.model;

import com.example.movieapp.compositekey.MovieCastKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movie_cast")
public class MovieCast {

    @EmbeddedId
    @Column(name = "movie_cast_key")
    MovieCastKey movieCastKey;

    @ManyToOne
    @MapsId("contentId")
    @JoinColumn(name = "content_id", nullable = false)
    private Content content;


    @ManyToOne
    @MapsId("movieRoleId")
    @JoinColumn(name = "movie_role_id", nullable = false)
    private MovieRole movieRoleId;

    @ManyToOne
    @MapsId("moviePeopleId")
    @JoinColumn(name = "movie_people_id",
            nullable = false)
    private MoviePeople moviePeopleId;

}
