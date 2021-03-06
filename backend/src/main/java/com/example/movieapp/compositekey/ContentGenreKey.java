package com.example.movieapp.compositekey;

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
public class ContentGenreKey implements Serializable {

    @Column(name = "genre_id")
    private Integer genreId;

    @Column(name = "content_id")
    private Integer contentId;
}
