package com.example.movieapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "review")
public class Review {
    @EmbeddedId
    @Column(name = "review_id")
    ReviewId reviewId;


    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name="user_id", nullable = false)
    @JsonIgnore
    private UserPerson userPerson;


    @ManyToOne
    @MapsId("contentId")
    @JoinColumn(name="content_id", nullable = false)
    private Content content;

    private Integer rating;
    private Boolean favourite;
}
