package com.example.movieapp.controller;
import com.example.movieapp.model.Season;
import com.example.movieapp.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/season")
public class SeasonController {
    @Autowired
    SeasonService seasonService;

    @PostMapping("save")
    public Season saveSeason(@RequestBody Season requestBody) {
        return seasonService.saveSeason(requestBody);
    }

    @GetMapping()
    public List<Season> getAll() {
        return seasonService.getAll();
    }

    @PutMapping("/update")
    public Season update(@RequestBody Season requestBody) {
        System.out.println(requestBody.getSeasonId());
        return seasonService.updateSeason(requestBody);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Integer item) {
        seasonService.deleteSeason(item);
    }
}
