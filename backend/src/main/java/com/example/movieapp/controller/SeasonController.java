package com.example.movieapp.controller;
import com.example.movieapp.dto.SeasonDto;
import com.example.movieapp.model.Season;
import com.example.movieapp.service.SeasonService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/season")
public class SeasonController {
    @Autowired
    SeasonService seasonService;

    @PostMapping("/save")
    public Season saveSeason(@RequestBody SeasonDto requestBody) throws NotFoundException {
        return seasonService.saveSeason(requestBody, requestBody.getContentId());
    }

    @GetMapping()
    public List<Season> getAll() {
        return seasonService.getAll();
    }

    @PutMapping("/update")
    public Season update(@RequestBody SeasonDto requestBody) throws NotFoundException {
        return seasonService.updateSeason(requestBody);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer item) throws NotFoundException {
        seasonService.deleteSeasonById(item);
    }
}
