package com.example.movieapp.dto;

import com.example.movieapp.model.ContentType;
import com.example.movieapp.model.Country;
import com.example.movieapp.model.Language;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContentDao {

    private Integer contentId;
    private String title;
    private Integer year;
    private Integer duration;
    private Date releaseDate;
    private Float rating;
    private String coverLink;
    private String trailerLink;
    private Integer countryId;
    private Integer contentTypeId;
    private Integer languageId;

    private List<Integer> genreIds;
}
