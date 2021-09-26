package com.example.movieapp.controller;

import com.example.movieapp.model.ContentType;
import com.example.movieapp.service.ContentTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/content_type")
public class ContentTypeController {
    @Autowired
    ContentTypeService contentTypeService;

    @PostMapping("save")
    public ContentType saveContentType(@RequestBody ContentType requestBody) {
        return contentTypeService.saveContentType(requestBody);
    }

    @GetMapping()
    public List<ContentType> getAll() {
        return contentTypeService.getAll();
    }

    @PutMapping("/update")
    public ContentType update(@RequestBody ContentType requestBody) {
        System.out.println(requestBody.getContentTypeId());
        return contentTypeService.updateContentType(requestBody);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Integer item) {
        contentTypeService.deleteContentType(item);
    }
}
