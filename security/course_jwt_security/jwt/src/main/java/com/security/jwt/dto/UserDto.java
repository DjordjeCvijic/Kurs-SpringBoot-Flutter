package com.security.jwt.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {

	private Integer userId;
	private String userName;
	private String firstName;
	private String lastName;
	private String adress;
	private String phoneNumber;
	private String email;
	private String password;
	private List<Integer> roleIds;
}
