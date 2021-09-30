package com.example.movieapp.service;

import com.example.movieapp.dto.ContentCommentDto;
import com.example.movieapp.model.Content;
import com.example.movieapp.model.ContentComment;
import com.example.movieapp.model.UserPerson;
import com.example.movieapp.repository.ContentCommentRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentCommentService {

    @Autowired
    ContentCommentRepository contentCommentRepository;
    @Autowired
    UserPersonService userPersonService;
    @Autowired
    ContentService contentService;

    public ContentComment saveContentComment(ContentCommentDto contentCommentDto) throws NotFoundException {
        ContentComment contentComment = contentCommentRepository.save(buildContentCommentFromDto(contentCommentDto));
        return contentComment;
    }

    public List<ContentComment> getAllContentComment(){
        return contentCommentRepository.findAll();
    }

    public ContentComment updateContentComment(ContentCommentDto contentCommentDto) throws NotFoundException {
        if (contentCommentRepository.existsById(contentCommentDto.getContentCommentId())) {
            return saveContentComment(contentCommentDto);

        }
        throw new NotFoundException("Nije pronađen Content comment sa id-em:" + contentCommentDto.getContentCommentId());
    }

    public void deleteContentCommentById(Integer id) throws NotFoundException {
        if (contentCommentRepository.existsById(id)) {
           List<ContentComment>list=contentCommentRepository.getByReplayToComment(getContentCommentById(id));
           for(ContentComment cc:list)
               deleteContentCommentById(cc.getContentCommentId());

           contentCommentRepository.deleteById(id);

        }
        throw new NotFoundException("Nije pronađen Content comment sa id-em:" + id);
    }
    private ContentComment buildContentCommentFromDto(ContentCommentDto contentCommentDto) throws NotFoundException {
        ContentComment contentComment = new ContentComment();
        if (contentCommentDto.getContentCommentId() != null)
            contentComment.setContentCommentId(contentCommentDto.getContentCommentId());
        contentComment.setComment(contentCommentDto.getComment());
        contentComment.setUserPerson(userPersonService.getUserPersonById(contentCommentDto.getUserPersonId()));
        contentComment.setContent(contentService.getContentById(contentCommentDto.getContentId()));
        if(contentCommentDto.getReplayToCommentId()!=null)
            contentComment.setReplayToComment(getContentCommentById(contentCommentDto.getReplayToCommentId()));
        return contentComment;

    }

    public ContentComment getContentCommentById(Integer id) throws NotFoundException {
        return contentCommentRepository.findById(id).orElseThrow(() -> new NotFoundException("Nije pronađena Content Commetn sa id-em:" + id));
    }



}
