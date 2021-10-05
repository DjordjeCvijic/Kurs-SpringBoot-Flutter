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

    @GetMapping("/getAll")
    public List<Season> getAll() {
        return seasonService.getAll();
    }

    @GetMapping()
    public Season findById(@RequestParam("id") Integer id) throws NotFoundException {
        return seasonService.getSeasonById(id);
    }

    @PutMapping("/update")
    public Season update(@RequestBody SeasonDto requestBody) throws NotFoundException {
        return seasonService.updateSeason(requestBody);
    }

    @DeleteMapping()
    public void delete(@RequestParam("id") Integer id) throws NotFoundException {
        seasonService.deleteSeasonById(id);
    }
}
