package com.security.jdbc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class UserRoleKey implements Serializable {

	@Column(name = "user_id", nullable = false)
	private int userId;

	@Column(name = "role_id", nullable = false)
	private int roleId;

}
