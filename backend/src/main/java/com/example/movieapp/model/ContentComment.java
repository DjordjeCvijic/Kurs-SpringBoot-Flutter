package com.example.movieapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "content_comment")
public class ContentComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contentCommentId;

    @Column(name = "comment", nullable = false)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "replay_to_comment", nullable = true)
    private ContentComment replayToComment;

    @ManyToOne
    @JoinColumn(name = "content_id", nullable = false)
    private Content content;

    @ManyToOne
    @JoinColumn(name = "user_person_id", nullable = false)
    private UserPerson userPerson;


}
