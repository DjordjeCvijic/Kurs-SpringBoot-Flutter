package com.example.movieapp.controller;


import com.example.movieapp.dto.ContentDao;
import com.example.movieapp.model.Content;
import com.example.movieapp.model.ContentComment;
import com.example.movieapp.service.ContentService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/content")
public class ContentController {
    @Autowired
    ContentService contentService;

    @GetMapping()
    public List<Content> getAll() {

        return contentService.getAll();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id) throws NotFoundException {
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

    @DeleteMapping("/delete")
    public void delete(@RequestParam Integer id) throws NotFoundException {
        contentService.deleteContent(id);
    }
}
