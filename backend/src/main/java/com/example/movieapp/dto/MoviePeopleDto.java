package com.example.movieapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MoviePeopleDto {

    private Integer moviePeopleId;

    private String firstName;

    private String lastName;

    private Date birthDate;

    private String gender;

    private List<Integer> movieRoleIds;
}
