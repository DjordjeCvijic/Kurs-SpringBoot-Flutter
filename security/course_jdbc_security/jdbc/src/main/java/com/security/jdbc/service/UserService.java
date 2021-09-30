package com.security.jdbc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.jdbc.dto.UserDto;
import com.security.jdbc.model.Role;
import com.security.jdbc.model.User;
import com.security.jdbc.model.UserRole;
import com.security.jdbc.model.UserRoleKey;
import com.security.jdbc.repository.RoleRepository;
import com.security.jdbc.repository.UserRepository;
import com.security.jdbc.repository.UserRoleRepository;

import javassist.NotFoundException;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRoleRepository userRoleRepository;

	// ulazni argument validirati na endpoint-u sa hibernate anotacijom
	// password mora biti hashovan kada se doda security
	public User save(UserDto userDto) {
		User user = userRepository.save(buildUserFromDto(userDto));
		userDto.getRoleIds().forEach(roleId -> {
			UserRoleKey key = new UserRoleKey(user.getUserId(), roleId);
			Role role = roleRepository.getById(roleId);
			userRoleRepository.save(new UserRole(key, user, role));
		});
		return userRepository.save(user);
	}

	public User findById(int id) throws NotFoundException {
		return userRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Nije pronađen korisnik sa id-em:" + id));
	}

	public Optional<User> findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public User update(UserDto userDto) throws NotFoundException {
		if (userRepository.existsById(userDto.getUserId())) {
			userRoleRepository.deleteByUser(findById(userDto.getUserId()));
			User user = userRepository.save(buildUserFromDto(userDto));
			userDto.getRoleIds().forEach(roleId -> {
				UserRoleKey key = new UserRoleKey(user.getUserId(), roleId);
				Role role = roleRepository.getById(roleId);
				userRoleRepository.save(new UserRole(key, user, role));
			});

			return user;
		}
		throw new NotFoundException("Nije pronađen korisnik sa id-em:" + userDto.getUserId());
	}

	public void delete(int id) throws NotFoundException {
		User user = findById(id);
		user.setActive(false);
		userRepository.save(user);
	}

	// password mora biti hashovan kada se doda security
	private User buildUserFromDto(UserDto userDto) {
		User user = new User();
		if (userDto.getUserId() != null)
			user.setUserId(userDto.getUserId());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setPassword(userDto.getPassword());
		user.setUsername(userDto.getUserName());

		return user;
	}

}
