package com.example.movieapp.model;

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
@Table(name="episode")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer episodeId;

    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "episodeNumber")
    private Integer episodeNumber;

    @ManyToOne
    @JoinColumn(name="season_id", nullable=false)
    private Season season;
}
