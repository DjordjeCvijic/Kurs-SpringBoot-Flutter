package com.example.movieapp.controller;

import com.example.movieapp.config.UserDetailsServiceImpl;
import com.example.movieapp.dto.UserPersonDto;
import com.example.movieapp.model.AuthenticationRequest;
import com.example.movieapp.model.AuthenticationResponse;
import com.example.movieapp.model.UserPerson;
import com.example.movieapp.service.UserPersonService;
import com.example.movieapp.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    UserPersonService userPersonService;

    @PostMapping( "/login")
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

    @PostMapping("/registration")
    public UserPerson saveUserPerson(@RequestBody UserPersonDto requestBody) {
        return userPersonService.saveUserPerson(requestBody);
    }
}
