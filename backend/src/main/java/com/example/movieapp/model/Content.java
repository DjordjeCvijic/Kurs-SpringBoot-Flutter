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

    @Column(name = "title",nullable = false)
    private String title;

    @Column(name = "year",nullable = false)
    private Integer year;

    @Column(name = "duration",nullable = true)
    private Integer duration;

    @Column(name = "releaseDate",nullable = false)
    private Date releaseDate;

    @Column(name = "rating",nullable = false)
    private Float rating;

    @Column(name = "coverLink",nullable = false)
    private String coverLink;

    @Column(name = "trailerLink",nullable = false)
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



}
