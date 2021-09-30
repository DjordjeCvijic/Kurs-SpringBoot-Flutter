package com.example.movieapp.dto;

import com.example.movieapp.model.Season;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EpisodeDto {
    private Integer episodeId;
    private Integer seasonId;
    private String name;
    private Integer duration;
    private Integer episodeNumber;
}
