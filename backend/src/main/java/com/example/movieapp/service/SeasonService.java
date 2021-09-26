package com.example.movieapp.service;


import com.example.movieapp.model.Season;
import com.example.movieapp.repository.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class SeasonService {
    @Autowired
    SeasonRepository seasonRepository;

    public Season saveSeason(@RequestBody Season requestBody) {
        System.out.println(requestBody.getSeasonId());
        return seasonRepository.save(requestBody);
    }

    public List<Season> getAll() {
        return seasonRepository.findAll();
    }

    public Season updateSeason(Season item) {
        Season season=seasonRepository.findById(item.getSeasonId()).get();
        season.setName(item.getName());
        seasonRepository.save(season);
        return season;
    }

    public void deleteSeason(Integer seasonId) {
        seasonRepository.deleteById(seasonId);
    }
}
