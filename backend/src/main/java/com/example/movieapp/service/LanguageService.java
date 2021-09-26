package com.example.movieapp.service;


import com.example.movieapp.model.Language;
import com.example.movieapp.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class LanguageService {
    @Autowired
    LanguageRepository languageRepository;

    public Language saveLanguage(@RequestBody Language requestBody) {
        System.out.println(requestBody.getLanguageId());
        return languageRepository.save(requestBody);
    }

    public List<Language> getAll() {
        return languageRepository.findAll();
    }

    public Language updateLanguage(Language item) {
        Language language=languageRepository.findById(item.getLanguageId()).get();
        language.setName(item.getName());
        languageRepository.save(language);
        return language;
    }

    public void deleteLanguage(Integer languageId) {
        languageRepository.deleteById(languageId);
    }
}
