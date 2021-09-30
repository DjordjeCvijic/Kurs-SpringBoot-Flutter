package com.example.movieapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContentCommentDto {

    Integer contentCommentId;
    String comment;
    Integer userPersonId;
    Integer contentId;
    Integer replayToCommentId;

}
