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
    private Integer userPersonId;

    @Column(name ="username",nullable = false)
    private String username;

    @Column(name ="firstName",nullable = false)
    private String firstName;

    @Column(name ="lastName",nullable = false)
    private String lastName;

    @Column(name ="address",nullable = true)
    private String address;

    @Column(name ="phoneNumber",nullable = true)
    private String phoneNumber;

    @Column(name ="email",nullable = false)
    private String email;

    @Column(name ="password",nullable = false)
    private String password;

    @Column(name = "active",nullable = false)
    private boolean active=true;
}
