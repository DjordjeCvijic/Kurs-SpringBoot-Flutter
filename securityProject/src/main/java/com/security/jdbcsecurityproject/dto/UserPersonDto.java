package com.security.jdbcsecurityproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserPersonDto {

    private Integer userId;

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Boolean active=true;
    private List<Integer> roleIds;//jer cemo odavde sad popunjavati veznu tabelu
}
