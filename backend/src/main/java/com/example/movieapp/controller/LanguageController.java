package com.example.movieapp.controller;

import com.example.movieapp.model.Language;
import com.example.movieapp.service.LanguageService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {
    @Autowired
    LanguageService languageService;

    @PostMapping("save")
    public Language saveLanguage(@RequestBody Language requestBody) {
        return languageService.saveLanguage(requestBody);
    }

    @GetMapping()
    public List<Language> getAll() {
        return languageService.getAll();
    }

    @PutMapping("/update")
    public Language update(@RequestBody Language requestBody) throws NotFoundException {
        return languageService.updateLanguage(requestBody);
    }

    @DeleteMapping()
    public void delete(@RequestParam("id") Integer id) {
        languageService.deleteLanguage(id);
    }
}
