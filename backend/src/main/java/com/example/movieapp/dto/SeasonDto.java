package com.example.movieapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeasonDto {

    Integer seasonId;
    String name;
    Integer seasonNumber;
    Integer contentId;
    List<MovieSerieCastDto> castList;
    List<EpisodeDto>episodeDtoList;

}
