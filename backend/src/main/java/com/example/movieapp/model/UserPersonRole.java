package com.example.movieapp.model;

import com.example.movieapp.compositekey.UserPersonRoleKey;
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
@Table(name = "user_person_role")
public class UserPersonRole {
    @EmbeddedId
    @Column(name = "user_person_role_key")
    UserPersonRoleKey userPersonRoleKey;


    @ManyToOne
    @MapsId("userPersonId")//kako se zove u veznoj tabel//mora se poklapati kao u kljucu
    @JoinColumn(name="user_id", nullable = false)//kako se zove u ovoj
    @JsonIgnore
    private UserPerson userPerson;


    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name="role_id", nullable = false)
    private Role role;
}
