package com.example.movieapp.config;

import com.example.movieapp.model.AuthUserDetails;
import com.example.movieapp.model.UserPerson;
import com.example.movieapp.model.UserPersonRole;
import com.example.movieapp.repository.UserPersonRoleRepository;
import com.example.movieapp.service.UserPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserPersonService userPersonService;

	@Autowired
	UserPersonRoleRepository userPersonRoleRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<UserPerson> user = userPersonService.getUserPersonByUsername(username);
		user.orElseThrow(() -> new UsernameNotFoundException("Nije pronađen korisnik sa username-om:" + username));
		List<UserPersonRole> userRoles = userPersonRoleRepository.findByUserPerson(user.get());

		return new AuthUserDetails(user, userRoles);
	}

}
