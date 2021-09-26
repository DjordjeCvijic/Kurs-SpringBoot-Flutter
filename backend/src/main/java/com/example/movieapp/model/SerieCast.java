package com.example.movieapp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "serie_cast")
public class SerieCast implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serieCastId;

    @ManyToOne
    @JoinColumn(name = "seasonId", nullable = false)
    private Season seasonId;

    @ManyToOne
    @JoinColumn(name = "moviePeopleId", nullable = false)
    private MoviePeople moviePeopleId;

    @ManyToOne
    @JoinColumn(name = "movieRoleId", nullable = false)
    private MovieRole movieRoleId;
}
