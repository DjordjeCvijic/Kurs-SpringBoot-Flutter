package com.example.movieapp.controller;

import com.example.movieapp.dto.ContentCommentDto;
import com.example.movieapp.dto.ContentDao;
import com.example.movieapp.model.Content;
import com.example.movieapp.model.ContentComment;
import com.example.movieapp.service.ContentCommentService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.MapsId;
import java.util.List;

@RestController
@RequestMapping("/content-comment")
public class ContentCommentController {

    @Autowired
    ContentCommentService contentCommentService;

    @GetMapping
    public List<ContentComment> getAll() {
        return contentCommentService.getAllContentComment();
    }

    @GetMapping("/{id}")
    public ContentComment findById(@PathVariable Integer id) throws NotFoundException {
        return contentCommentService.getContentCommentById(id);
    }

    @PostMapping("/save")
    public ContentComment saveContent(@RequestBody ContentCommentDto requestBody) throws NotFoundException {
        return contentCommentService.saveContentComment(requestBody);
    }

    @PutMapping("/update")
    public ContentComment update(@RequestBody ContentCommentDto requestBody) throws NotFoundException {
        return contentCommentService.updateContentComment(requestBody);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws NotFoundException {
        contentCommentService.deleteContentCommentById(id);
    }

}
