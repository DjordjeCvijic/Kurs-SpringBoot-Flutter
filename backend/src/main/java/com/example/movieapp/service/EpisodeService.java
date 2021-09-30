package com.example.movieapp.service;


import com.example.movieapp.dto.EpisodeDto;
import com.example.movieapp.model.Content;
import com.example.movieapp.model.Episode;
import com.example.movieapp.model.Season;
import com.example.movieapp.repository.EpisodeRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EpisodeService {
    @Autowired
    EpisodeRepository episodeRepository;
    @Autowired
    SeasonService seasonService;

    public Episode saveEpisode(EpisodeDto episodeDto,Integer seasonId) throws NotFoundException {
        return episodeRepository.save(buildEpisodeFromDto(episodeDto,seasonId));
    }

    private Episode buildEpisodeFromDto(EpisodeDto episodeDto,Integer seasonId) throws NotFoundException {
        Episode episode=new Episode();
        if(episodeDto.getEpisodeId()!=null)
            episode.setEpisodeId(episodeDto.getEpisodeId());
        episode.setSeason(seasonService.getSeasonById(seasonId));
        episode.setName(episodeDto.getName());
        episode.setDuration(episodeDto.getDuration());
        episode.setEpisodeNumber(episodeDto.getEpisodeNumber());
        return  episode;
    }

    public List<Episode> getAll() {
        return episodeRepository.findAll();
    }
    public Episode getEpisodeById(Integer id) throws NotFoundException {
        return episodeRepository.findById(id).orElseThrow(() -> new NotFoundException("Nije pronađena Content sa id-em:" + id));
    }

    public Episode updateEpisode(EpisodeDto item) throws NotFoundException {

        Episode episode=getEpisodeById(item.getEpisodeId());
        saveEpisode(item,item.getSeasonId());
        return episode;
    }

    public void deleteEpisode(Integer episodeId) {
        episodeRepository.deleteById(episodeId);
    }

    public void deleteEpisodeBySeason(Season season) {
        episodeRepository.deleteBySeason(season);
    }
}
