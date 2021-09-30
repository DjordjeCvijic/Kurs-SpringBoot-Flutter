package com.security.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.jwt.cofing.UserDetailsServiceImpl;
import com.security.jwt.model.AuthenticationRequest;
import com.security.jwt.model.AuthenticationResponse;
import com.security.jwt.service.UserService;
import com.security.jwt.util.JwtUtil;

@RestController
@RequestMapping(value = "/test")
public class TestController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	UserService userService;

	@GetMapping
	public String guest() {
		return "Hello guest!";
	}

	@GetMapping("/admin")
	public String admin() {
		return "Hello admin!";
	}

	@GetMapping("/user")
	public String user() {
		return "Hello user!";
	}

	@GetMapping("/")
	public String home() {
		return ("<h1>Welcome!</h1>");
	}

	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		try {
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);//tu se sacuvan ulogovan korisnik
		} catch (BadCredentialsException ex) {
			return new ResponseEntity<String>("Pogrešni kredencijali!", HttpStatus.BAD_REQUEST);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtUtil.generateToken(userDetails);

		return new ResponseEntity<AuthenticationResponse>(new AuthenticationResponse(jwt), HttpStatus.OK);
	}
}
