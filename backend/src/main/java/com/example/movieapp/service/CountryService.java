package com.example.movieapp.service;


import com.example.movieapp.model.Country;
import com.example.movieapp.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    CountryRepository countryRepository;

    public Country saveCountry(@RequestBody Country requestBody) {
        System.out.println(requestBody.getCountryId());
        return countryRepository.save(requestBody);
    }

    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    public Country updateCountry(Country item) {
        Country country=countryRepository.findById(item.getCountryId()).get();
        country.setName(item.getName());
        countryRepository.save(country);
        return country;
    }

    public void deleteCountry(Integer countryId) {
        countryRepository.deleteById(countryId);
    }
}
