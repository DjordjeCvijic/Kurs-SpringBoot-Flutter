package com.example.movieapp.controller;

import com.example.movieapp.model.Language;
import com.example.movieapp.service.LanguageService;
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
    public Language update(@RequestBody Language requestBody) {
        System.out.println(requestBody.getLanguageId());
        return languageService.updateLanguage(requestBody);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Integer item) {
        languageService.deleteLanguage(item);
    }
}
