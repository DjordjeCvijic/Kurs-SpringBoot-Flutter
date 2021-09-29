package com.example.movieapp.service;


import com.example.movieapp.model.Country;
import com.example.movieapp.model.Language;
import com.example.movieapp.repository.LanguageRepository;
import javassist.NotFoundException;
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

    public Language updateLanguage(Language item) throws NotFoundException {
        Language language=getLanguageId(item.getLanguageId());
        language.setName(item.getName());
        languageRepository.save(language);
        return language;
    }
    public Language getLanguageId(Integer id) throws NotFoundException {
        return languageRepository.findById(id).orElseThrow(() -> new NotFoundException("Nije pronađen jezik sa id-em:" + id));
    }

    public void deleteLanguage(Integer languageId) {
        languageRepository.deleteById(languageId);
    }
}
