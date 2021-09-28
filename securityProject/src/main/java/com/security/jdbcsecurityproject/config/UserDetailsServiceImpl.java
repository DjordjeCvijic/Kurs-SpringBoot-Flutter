package com.security.jdbcsecurityproject.config;

import java.util.List;
import java.util.Optional;

import com.security.jdbcsecurityproject.model.AuthUserDetails;
import com.security.jdbcsecurityproject.model.UserPerson;
import com.security.jdbcsecurityproject.model.UserRole;
import com.security.jdbcsecurityproject.repository.UserRoleRepository;
import com.security.jdbcsecurityproject.service.UserPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserPersonService userService;

	@Autowired
	UserRoleRepository userRoleRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<UserPerson> user = userService.findUserByUsername(username);
		user.orElseThrow(() -> new UsernameNotFoundException("Nije pronađen korisnik sa username-om:" + username));
		List<UserRole> userRoles = userRoleRepository.findByUserPerson(user.get());

		return new AuthUserDetails(user, userRoles);
	}

}
