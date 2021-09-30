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
@Table(name = "season")
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seasonId;

    @Column(name = "name")
    private String name;

    @Column(name = "season_number")
    private Integer seasonNumber;

    @ManyToOne
    @JoinColumn(name="content_id", nullable = false)
    private Content content;
}
