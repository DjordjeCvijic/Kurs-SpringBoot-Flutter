package com.example.movieapp.model;

import com.example.movieapp.compositekey.ContentGenreKey;
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
    @Column(name = "content_genre_key")
    ContentGenreKey contentGenreKey;


    @ManyToOne
    @MapsId("contentId")
    @JoinColumn(name="content_id", nullable = false)
    private Content content;


    @ManyToOne
    @MapsId("genreId")
    @JoinColumn(name="genre_id", nullable = false)
    private Genre genre;
}
