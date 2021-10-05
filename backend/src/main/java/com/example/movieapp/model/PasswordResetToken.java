package com.example.movieapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "password_reset_token")
public class PasswordResetToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "token_id")
    private int tokenId;

    @Column(name = "token")
    private String token;

    @OneToOne(targetEntity = UserPerson.class)
    @JoinColumn(nullable = false, name = "user_person_id")
    private UserPerson userPerson;

    @Column(name = "expiry_date")
    private LocalDateTime expiryDate;
}
