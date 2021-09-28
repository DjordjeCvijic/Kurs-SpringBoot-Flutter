package com.security.jdbcsecurityproject.model;

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
@Table(name = "user_role")
public class UserRole {
    @EmbeddedId
    @Column(name = "user_role_id")
    UserRoleId userRoleId;


    @ManyToOne
    @MapsId("userId")//kako se zove u veznoj tabeli
    @JoinColumn(name="user_id", nullable = false)//kako se zove u ovoj
    @JsonIgnore
    private UserPerson userPerson;


    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name="role_id", nullable = false)
    private Role role;
}
