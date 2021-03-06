package com.example.movieapp.service;

import com.example.movieapp.compositekey.MovieCastKey;
import com.example.movieapp.dto.ContentDao;
import com.example.movieapp.model.*;
import com.example.movieapp.compositekey.ContentGenreKey;
import com.example.movieapp.repository.ContentRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Autowired
    MovieCastService movieCastService;
    @Autowired
    MovieRoleService movieRoleService;
    @Autowired
    MoviePeopleService moviePeopleService;
    @Autowired
    SeasonService seasonService;
    @Autowired
    ReviewService reviewService;


    public Content saveContent(@RequestBody ContentDao contentDao) throws NotFoundException {
        Content content = contentRepository.save(buildContentFromDto(contentDao));
        contentDao.getGenreIds().forEach(genreId -> {
            ContentGenreKey key = new ContentGenreKey(genreId, contentDao.getContentId());
            try {
                Genre genre = genreService.getGenreById(genreId);
                contentGenreService.saveContentGenre(new ContentGenre(key, content, genre));
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
        if (contentDao.getMovieSerieCastDtos() != null) {
            //radi se o filmu i sada treba popuniti tabelu  Movie Cast
            contentDao.getMovieSerieCastDtos().forEach(movieCastDto -> {
                MovieCastKey key = new MovieCastKey(content.getContentId(), movieCastDto.getMovieRoleId(), movieCastDto.getMoviePeopleId());
                try {
                    MoviePeople moviePeople = moviePeopleService.getMoviePeopleById(movieCastDto.getMoviePeopleId());
                    MovieRole movieRole = movieRoleService.getMovieRoleById(movieCastDto.getMovieRoleId());
                    movieCastService.saveMovieCast(new MovieCast(key, content, movieRole, moviePeople));
                } catch (NotFoundException e) {
                    e.printStackTrace();
                }

            });
        }
        if (contentDao.getSeasonDtoList() != null) {
            contentDao.getSeasonDtoList().forEach(seasonDto -> {
                try {
                    seasonService.saveSeason(seasonDto, content.getContentId());
                } catch (NotFoundException e) {
                    e.printStackTrace();
                }
            });
        }


        return content;
    }


    public List<Content> getAll() {
        return contentRepository.findAll();
    }

    public Content updateContent(ContentDao contentDaoToSave) throws NotFoundException {
        Content content = getContentById(contentDaoToSave.getContentId());
        //brisanje zapisa iz vezne tabele
        contentGenreService.deleteContentGenreByContent(content);
        movieCastService.deleteMovieCastByContent(content);
        seasonService.deleteSeasonByContent(content);
        return saveContent(contentDaoToSave);
    }

    public void deleteContent(Integer contentId) throws NotFoundException {
        if (contentRepository.existsById(contentId)) {
            contentGenreService.deleteContentGenreByContent(getContentById(contentId));
            movieCastService.deleteMovieCastByContent(getContentById(contentId));
            seasonService.deleteSeasonByContent(getContentById(contentId));
            reviewService.deleteReviewByContent(getContentById(contentId));
            contentRepository.deleteById(contentId);
        } else throw new NotFoundException("Nije prona??ena Content sa id-em:" + contentId);


    }

    private Content buildContentFromDto(ContentDao contentDao) throws NotFoundException {

        Content content = new Content();
        if (contentDao.getContentId() != null)
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
        return contentRepository.findById(id).orElseThrow(() -> new NotFoundException("Nije prona??ena Content sa id-em:" + id));
    }

    public Content updateRating(Content content) {
        return contentRepository.save(content);
    }

    public List<Content> getMovieContentByGenre(Integer genreId, Optional<Integer> numOfElement) throws NotFoundException {
        List<ContentGenre> contentGenreList = contentGenreService.findByGenre(genreService.getGenreById(genreId));//filtrirano po zanru
        List<Content> movieContent = new LinkedList<>() {
        };
        contentGenreList.forEach(contentGenre -> {
            if (contentGenre.getContent().getContentType().getContentTypeId() == 1)//to znaci da je film
                movieContent.add(contentGenre.getContent());
        });
        if (numOfElement.isPresent()) {
            return movieContent.stream().limit(numOfElement.get()).collect(Collectors.toList());
        }
        return movieContent;

    }

    public List<Content> getSeriesContentByGenre(Integer genreId, Optional<Integer> numOfElement) throws NotFoundException {
        List<ContentGenre> contentGenreList = contentGenreService.findByGenre(genreService.getGenreById(genreId));//filtrirano po zanru
        List<Content> serieContent = new LinkedList<>() {
        };
        contentGenreList.forEach(contentGenre -> {
            if (contentGenre.getContent().getContentType().getContentTypeId() == 2)//to znaci da je serija
                serieContent.add(contentGenre.getContent());
        });
        if (numOfElement.isPresent()) {
            return serieContent.stream().limit(numOfElement.get()).collect(Collectors.toList());
        }
        return serieContent;
    }
}
