package com.example.movieapp.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "content_comment")
public class ContentComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    @ManyToOne
    @JoinColumn(name = "contentId", nullable = false)
    private Content contentId;
    private String comment;
    @Nullable
    private Integer replayId;
}
