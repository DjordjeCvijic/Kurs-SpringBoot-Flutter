package com.example.movieapp.model;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "userPerson")
public class UserPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String userName;
    private String firstName;
    private String lastName;
    @Nullable
    private String address;
    @Nullable
    private String phoneNumber;
    private String email;
    private String password;
}
