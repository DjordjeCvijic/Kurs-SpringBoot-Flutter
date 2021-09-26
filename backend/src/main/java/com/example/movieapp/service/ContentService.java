package com.example.movieapp.service;

import com.example.movieapp.model.Content;
import com.example.movieapp.repository.ContentRepository;
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

    public List<Content> getAll() {
        return contentRepository.findAll();
    }

    public Content saveContent(@RequestBody Content requestBody) {
        System.out.println(requestBody.getContentId());
        return contentRepository.save(requestBody);
    }

    public Content updateContent(Content item) {
        Content content = contentRepository.findById(item.getContentId()).get();
        content.setTitle(item.getTitle());
        contentRepository.save(content);
        return content;
    }

    public void deleteContent(Integer contentId) {
        contentRepository.deleteById(contentId);
    }
}
