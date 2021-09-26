package com.example.movieapp.controller;


import com.example.movieapp.model.Content;
import com.example.movieapp.service.ContentService;
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

    @PostMapping("save")
    public Content saveContent(@RequestBody Content requestBody) {
        return contentService.saveContent(requestBody);
    }

    @PutMapping("/update")
    public Content update(@RequestBody Content requestBody) {
        System.out.println(requestBody.getContentId());
        return contentService.updateContent(requestBody);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Integer item) {
        contentService.deleteContent(item);
    }
}
