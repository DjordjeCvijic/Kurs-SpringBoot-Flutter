package com.example.movieapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "content")
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contentId;
    private String title;
    private Integer year;
    @Nullable
    private Integer duration;
    private Date releaseDate;
    private Float rating;
    private String coverLink;
    private String trailerLink;
    @ManyToOne
    @JoinColumn(name = "countryId", nullable = false)
    private Country countryId;
    @ManyToOne
    @JoinColumn(name = "contentTypeId", nullable = false)
    private ContentType contentTypeId;
    @ManyToOne
    @JoinColumn(name = "languageId", nullable = false)
    private Language languageId;

    @OneToMany(mappedBy = "content")
    private List<ContentGenre> contentGenreList;

}
