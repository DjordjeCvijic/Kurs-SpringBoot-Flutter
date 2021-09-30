package com.example.movieapp.service;


import com.example.movieapp.compositekey.SerieCastKey;
import com.example.movieapp.dto.ContentCommentDto;
import com.example.movieapp.dto.SeasonDto;
import com.example.movieapp.model.*;
import com.example.movieapp.repository.SeasonRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class SeasonService {
    @Autowired
    SeasonRepository seasonRepository;
    @Autowired
    ContentService contentService;
    @Autowired
    SerieCastService serieCastService;
    @Autowired
    MovieRoleService movieRoleService;
    @Autowired
    MoviePeopleService moviePeopleService;
    @Autowired
    EpisodeService episodeService;

    public Season saveSeason(SeasonDto seasonDto, Integer contentId) throws NotFoundException {
        Season season = seasonRepository.save(buildSeasonFromDto(seasonDto, contentId));
        seasonDto.getCastList().forEach(movieSerieCastDto -> {
            SerieCastKey key = new SerieCastKey(season.getSeasonId(), movieSerieCastDto.getMovieRoleId(), movieSerieCastDto.getMoviePeopleId());
            try {
                MovieRole movieRole = movieRoleService.getMovieRoleById(movieSerieCastDto.getMovieRoleId());
                MoviePeople moviePeople = moviePeopleService.getMoviePeopleById(movieSerieCastDto.getMoviePeopleId());
                serieCastService.saveSerieCast(new SerieCast(key, season, moviePeople, movieRole));

            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
        seasonDto.getEpisodeDtoList().forEach(episodeDto -> {
            try {
                episodeService.saveEpisode(episodeDto, season.getSeasonId());
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });

        return season;

    }

    private Season buildSeasonFromDto(SeasonDto seasonDto, Integer contentId) throws NotFoundException {
        Season season = new Season();
        if (seasonDto.getSeasonId() != null)
            season.setSeasonId(seasonDto.getSeasonId());
        season.setName(seasonDto.getName());
        season.setSeasonNumber(seasonDto.getSeasonNumber());
        season.setContent(contentService.getContentById(contentId));
        return season;
    }

    public List<Season> getAll() {
        return seasonRepository.findAll();
    }

    public Season updateSeason(SeasonDto seasonDto) throws NotFoundException {
        if (seasonRepository.existsById(seasonDto.getSeasonId())) {
            serieCastService.deleteSerieCastBySeason(getSeasonById(seasonDto.getSeasonId()));
            episodeService.deleteEpisodeBySeason(getSeasonById(seasonDto.getSeasonId()));
            saveSeason(seasonDto, seasonDto.getContentId());
        }
        throw new NotFoundException("Nije pronađen Content comment sa id-em:" + seasonDto.getSeasonId());
    }

    public void deleteSeasonById(Integer id) throws NotFoundException {
        if (seasonRepository.existsById(id)) {
            Season seasonToDelete=getSeasonById(id);
            serieCastService.deleteSerieCastBySeason(getSeasonById(id));
            episodeService.deleteEpisodeBySeason(seasonToDelete);

            seasonRepository.deleteById(id);

        }
        throw new NotFoundException("Nije pronađea sezona sa id-em:" + id);
    }

    public Season getSeasonById(Integer id) throws NotFoundException {
        return seasonRepository.findById(id).orElseThrow(() -> new NotFoundException("Nije pronađena sezona sa id-em:" + id));

    }


    public void deleteSeasonByContent(Content content) {
        List<Season>seasons=seasonRepository.findByContent(content);
        seasons.forEach(season -> {
            try {
                deleteSeasonById(season.getSeasonId());
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }
}
