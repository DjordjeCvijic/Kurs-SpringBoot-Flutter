package com.example.movieapp.service;


import com.example.movieapp.model.Episode;
import com.example.movieapp.repository.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EpisodeService {
    @Autowired
    EpisodeRepository episodeRepository;

    public Episode saveEpisode(@RequestBody Episode requestBody) {
        System.out.println(requestBody.getEpisodeId());
        return episodeRepository.save(requestBody);
    }

    public List<Episode> getAll() {
        return episodeRepository.findAll();
    }

    public Episode updateEpisode(Episode item) {
        Episode episode=episodeRepository.findById(item.getEpisodeId()).get();
        episode.setName(item.getName());
        episodeRepository.save(episode);
        return episode;
    }

    public void deleteEpisode(Integer episodeId) {
        episodeRepository.deleteById(episodeId);
    }
}
