package com.example.movieapp.controller;
import com.example.movieapp.model.Country;
import com.example.movieapp.service.CountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    CountryService countryService;

    @PostMapping("save")
    public Country saveCountry(@RequestBody Country requestBody) {
        return countryService.saveCountry(requestBody);
    }

    @GetMapping("getAll")
    public List<Country> getAll() {
        return countryService.getAll();
    }

    @PutMapping("/update")
    public Country update(@RequestBody Country requestBody) {
        System.out.println(requestBody.getCountryId());
        return countryService.updateCountry(requestBody);
    }

    @DeleteMapping()
    public void deleteById(@RequestParam("id") Integer id) {
        countryService.deleteCountry(id);
    }
}
