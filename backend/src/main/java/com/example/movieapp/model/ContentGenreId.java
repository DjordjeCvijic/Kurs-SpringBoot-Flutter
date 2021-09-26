package com.example.movieapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ContentGenreId implements Serializable {

    @Column(name = "genre_id")
    private Integer genreId;

    @Column(name = "content_id")
    private Integer contentId;
}
