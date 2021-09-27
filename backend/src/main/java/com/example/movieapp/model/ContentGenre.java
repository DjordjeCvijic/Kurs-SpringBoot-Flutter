package com.example.movieapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "content_genre")
public class ContentGenre {
    @EmbeddedId
    @Column(name = "content_genre_id")
    ContentGenreId contentGenreId;


    @ManyToOne
    @MapsId("contentId")
    @JoinColumn(name="content_id", nullable = false)
    @JsonIgnore
    private Content content;


    @ManyToOne
    @MapsId("genreId")
    @JoinColumn(name="genre_id", nullable = false)
    @JsonIgnore
    private Genre genre;
}
