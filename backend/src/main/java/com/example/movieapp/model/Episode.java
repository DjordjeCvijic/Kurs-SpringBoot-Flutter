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
    private String name;
    private Integer duration;
    private Integer episodeNumber;

    @ManyToOne
    @JoinColumn(name="seasonId", nullable=false)
    private Season seasonId;
}
