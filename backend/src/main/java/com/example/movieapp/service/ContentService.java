package com.example.movieapp.service;

import com.example.movieapp.dto.ContentDao;
import com.example.movieapp.model.Content;
import com.example.movieapp.model.ContentGenre;
import com.example.movieapp.model.ContentGenreKey;
import com.example.movieapp.model.Genre;
import com.example.movieapp.repository.ContentRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.swing.text.AbstractDocument;
import java.util.List;

@Service
public class ContentService {

    @Autowired
    ContentRepository contentRepository;
    @Autowired
    CountryService countryService;
    @Autowired
    ContentTypeService contentTypeService;
    @Autowired
    LanguageService languageService;
    @Autowired
    GenreService genreService;
    @Autowired
    ContentGenreService contentGenreService;

    public Content saveContent(@RequestBody ContentDao contentDao) throws NotFoundException {
        Content content=contentRepository.save(buildContentFromDto(contentDao));
        contentDao.getGenreIds().forEach(genreId->{
            ContentGenreKey key=new ContentGenreKey(genreId, contentDao.getContentId());
            try {
                Genre genre=genreService.getGenreById(genreId);
                contentGenreService.saveContentGenre(new ContentGenre(key,content,genre));
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });

        return content;
    }



    public List<Content> getAll() {
        return contentRepository.findAll();
    }

    public Content updateContent(ContentDao contentDaoToSave) throws NotFoundException {
        Content content=getContentById(contentDaoToSave.getContentId());
        //brisanje zapisa iz vezne tabele
        contentGenreService.deleteContentGenreByContent(content);
        return saveContent(contentDaoToSave);
    }

    public void deleteContent(Integer contentId) throws NotFoundException {
        contentGenreService.deleteContentGenreByContent(getContentById(contentId));
        contentRepository.deleteById(contentId);
    }

    private Content buildContentFromDto(ContentDao contentDao) throws NotFoundException {

        Content content=new Content();
        if(contentDao.getContentId()!=null)
            content.setContentId(contentDao.getContentId());
        content.setTitle(contentDao.getTitle());
        content.setYear(contentDao.getYear());
        content.setDuration(contentDao.getDuration());
        content.setReleaseDate(contentDao.getReleaseDate());
        content.setRating(contentDao.getRating());
        content.setCoverLink(contentDao.getCoverLink());
        content.setTrailerLink(contentDao.getTrailerLink());
        content.setCountry(countryService.getCountryById(contentDao.getCountryId()));
        content.setContentType(contentTypeService.getContentTypeById(contentDao.getContentTypeId()));
        content.setLanguage(languageService.getLanguageById(contentDao.getLanguageId()));
        return content;
    }

    public Content getContentById(Integer id) throws NotFoundException {
        return contentRepository.findById(id).orElseThrow(() -> new NotFoundException("Nije pronađena Content sa id-em:" + id));
    }
}
