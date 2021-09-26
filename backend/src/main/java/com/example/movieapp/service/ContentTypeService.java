package com.example.movieapp.service;


import com.example.movieapp.model.ContentType;
import com.example.movieapp.repository.ContentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ContentTypeService {
    @Autowired
    ContentTypeRepository contentTypeRepository;

    public ContentType saveContentType(@RequestBody ContentType requestBody) {
        System.out.println(requestBody.getContentTypeId());
        return contentTypeRepository.save(requestBody);
    }

    public List<ContentType> getAll() {
        return contentTypeRepository.findAll();
    }

    public ContentType updateContentType(ContentType item) {
        ContentType contentType=contentTypeRepository.findById(item.getContentTypeId()).get();
        contentType.setName(item.getName());
        contentTypeRepository.save(contentType);
        return contentType;
    }

    public void deleteContentType(Integer contentTypeId) {
        contentTypeRepository.deleteById(contentTypeId);
    }
}
