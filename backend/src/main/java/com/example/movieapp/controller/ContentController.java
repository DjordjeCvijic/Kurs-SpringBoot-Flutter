package com.example.movieapp.controller;


import com.example.movieapp.dto.ContentDao;
import com.example.movieapp.model.Content;
import com.example.movieapp.model.ContentComment;
import com.example.movieapp.service.ContentService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/content")
public class ContentController {
    @Autowired
    ContentService contentService;

    @GetMapping("/getAll")
    public List<Content> getAll() {
        return contentService.getAll();
    }


    @GetMapping()
    public Content findById(@RequestParam("id") Integer id) throws NotFoundException {
        return contentService.getContentById(id);
    }

    @PostMapping("/save")
    public Content saveContent(@RequestBody ContentDao requestBody) throws NotFoundException {
        return contentService.saveContent(requestBody);
    }

    @PutMapping("/update")
    public Content update(@RequestBody ContentDao requestBody) throws NotFoundException {
        System.out.println(requestBody.getContentId());
        return contentService.updateContent(requestBody);
    }


    @DeleteMapping()
    public void delete(@RequestParam("id") Integer id) throws NotFoundException {
        contentService.deleteContent(id);
    }

    @GetMapping("/movie-by-genre")
    public List<Content> getMovieContentByGenre(@RequestParam("genreId") Integer genreId,@RequestParam("numOfElement") Optional<Integer> numOfElement) throws NotFoundException {
        return contentService.getMovieContentByGenre(genreId,numOfElement);
    }
    @GetMapping("/series-by-genre")
    public List<Content> getSeriesContentByGenre(@RequestParam("genreId") Integer genreId,@RequestParam("numOfElement") Optional<Integer> numOfElement) throws NotFoundException {
        return contentService.getSeriesContentByGenre(genreId,numOfElement);
    }
}
