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
public class MovieCastKey implements Serializable {

    @Column(name = "content_id")
    private Integer contentId;

    @Column(name = "movie_role_id")
    private Integer movieRoleId;

    @Column(name = "movie_people_id")
    private Integer moviePeopleId;
}
