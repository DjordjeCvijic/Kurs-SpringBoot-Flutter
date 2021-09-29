package com.example.movieapp.service;


import com.example.movieapp.model.ContentType;
import com.example.movieapp.model.Country;
import com.example.movieapp.repository.ContentTypeRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ContentTypeService {
    @Autowired
    ContentTypeRepository contentTypeRepository;

    public ContentType saveContentType(@RequestBody ContentType requestBody) {
        return contentTypeRepository.save(requestBody);
    }

    public List<ContentType> getAll() {
        return contentTypeRepository.findAll();
    }

    public ContentType updateContentType(ContentType item) throws NotFoundException {
        ContentType contentType=getContentTypeById(item.getContentTypeId());
        contentType.setName(item.getName());
        contentTypeRepository.save(contentType);
        return contentType;
    }
    public ContentType getContentTypeById(Integer id) throws NotFoundException {
        return contentTypeRepository.findById(id).orElseThrow(() -> new NotFoundException("Nije pronađen content type sa id-em:" + id));
    }

    public void deleteContentType(Integer contentTypeId) {
        contentTypeRepository.deleteById(contentTypeId);
    }
}
