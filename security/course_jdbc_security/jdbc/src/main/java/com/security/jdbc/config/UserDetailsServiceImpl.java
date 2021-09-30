package com.security.jdbc.config;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.jdbc.model.AuthUserDetails;
import com.security.jdbc.model.User;
import com.security.jdbc.model.UserRole;
import com.security.jdbc.repository.UserRoleRepository;
import com.security.jdbc.service.UserService;

@Service
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserService userService;

	@Autowired
	UserRoleRepository userRoleRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> user = userService.findUserByUsername(username);
		user.orElseThrow(() -> new UsernameNotFoundException("Nije pronađen korisnik sa username-om:" + username));
		List<UserRole> userRoles = userRoleRepository.findByUser(user.get());

		return new AuthUserDetails(user, userRoles);
	}

}
