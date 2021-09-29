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
@Table(name = "movie_role")
public class MovieRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieRoleId;

    @Column(name = "name",nullable = false)
    private String name;

    public Integer getMovieRoleId() {
        return movieRoleId;
    }

    public void setMovieRoleId(Integer movieRoleId) {
        this.movieRoleId = movieRoleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
