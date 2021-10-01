package com.example.movieapp.model;

import com.example.movieapp.compositekey.ReviewKey;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    ReviewKey reviewKey;


    @ManyToOne
    @MapsId("userPersonId")
    @JoinColumn(name="user_person_id", nullable = false)
    @JsonIgnore
    private UserPerson userPerson;


    @ManyToOne
    @MapsId("contentId")
    @JoinColumn(name="content_id", nullable = false)
    private Content content;

    @Column(name = "rating", nullable = true)
    private Integer rating=0;

    @Column(name = "favourite", nullable = true)
    private Boolean favourite;
}
