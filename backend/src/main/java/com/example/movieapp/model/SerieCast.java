package com.example.movieapp.model;

import com.example.movieapp.compositekey.MovieCastKey;
import com.example.movieapp.compositekey.SerieCastKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "serie_cast")
public class SerieCast {

    @EmbeddedId
    @Column(name = "serie_cast_key")
    SerieCastKey serieCastKey;

    @ManyToOne
    @MapsId("seasonId")
    @JoinColumn(name = "season_id", nullable = false)
    private Season season;

    @ManyToOne
    @MapsId("moviePeopleId")
    @JoinColumn(name = "movie_people_id", nullable = false)
    private MoviePeople moviePeople;

    @ManyToOne
    @MapsId("movieRoleId")
    @JoinColumn(name = "movie_role_id", nullable = false)
    private MovieRole movieRole;
}
