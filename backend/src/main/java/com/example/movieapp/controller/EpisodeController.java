package com.example.movieapp.controller;

import com.example.movieapp.model.Episode;
import com.example.movieapp.service.EpisodeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/episode")
public class EpisodeController {
    @Autowired
    EpisodeService episodeService;

    @PostMapping("save")
    public Episode saveEpisode(@RequestBody Episode requestBody) {
        return episodeService.saveEpisode(requestBody);
    }

    @GetMapping()
    public List<Episode> getAll() {
        return episodeService.getAll();
    }

    @PutMapping("/update")
    public Episode update(@RequestBody Episode requestBody) {
        System.out.println(requestBody.getEpisodeId());
        return episodeService.updateEpisode(requestBody);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Integer item) {
        episodeService.deleteEpisode(item);
    }
}
