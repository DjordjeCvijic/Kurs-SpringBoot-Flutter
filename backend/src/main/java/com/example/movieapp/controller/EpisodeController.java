package com.example.movieapp.controller;

import com.example.movieapp.dto.EpisodeDto;
import com.example.movieapp.model.Content;
import com.example.movieapp.model.Episode;
import com.example.movieapp.service.EpisodeService;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/episode")
public class EpisodeController {
    @Autowired
    EpisodeService episodeService;

    @PostMapping("/save")
    public Episode saveEpisode(@RequestBody EpisodeDto requestBody) throws NotFoundException {
        return episodeService.saveEpisode(requestBody,requestBody.getSeasonId());
    }

    @GetMapping("getAll")
    public List<Episode> getAll() {
        return episodeService.getAll();
    }

    @GetMapping()
    public Episode findById(@RequestParam("id") Integer id) throws NotFoundException {
        return episodeService.getEpisodeById(id);
    }

    @PutMapping("/update")
    public Episode update(@RequestBody EpisodeDto requestBody) throws NotFoundException {
        return episodeService.updateEpisode(requestBody);
    }

    @DeleteMapping()
    public void delete(@RequestParam("id") Integer id) throws NotFoundException {
        episodeService.deleteEpisode(id);
    }
}
