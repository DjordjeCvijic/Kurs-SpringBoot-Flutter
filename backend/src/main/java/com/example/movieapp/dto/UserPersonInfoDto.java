package com.example.movieapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserPersonInfoDto {

    public Integer userPersonId;
    public String firstName;
    public String lastName;
    public String address;
    public String phoneNumber;
    public String username;

}
