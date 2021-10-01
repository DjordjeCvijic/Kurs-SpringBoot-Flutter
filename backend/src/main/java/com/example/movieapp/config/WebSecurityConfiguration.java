package com.example.movieapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Autowired
	JwtRequestFilter jwtRequestFilter;

	String[] adminPermissionsList={"/movie-people/**","/content/**"};
	String[] userPermissionsList={};
	String[] userAndAminPermissionsList={"/content-comment/**","/review/**","/genre","user-person/update-info"};
	String[] swaggerPermissionsList={"/swagger-ui/*", "/swagger-ui.html", "/webjars/**", "/v2/**", "/swagger-resources/**"};
	String[] permissionsForAllList={"/auth/**"};

	// authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
	}

	// authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off

		http
				.csrf().disable()
				.authorizeRequests()
				.antMatchers(permissionsForAllList).permitAll()
				//.antMatchers("/swagger-resources/**").permitAll()
				.antMatchers(swaggerPermissionsList).permitAll()
				.antMatchers(adminPermissionsList).hasRole("ADMIN")
				.antMatchers(userPermissionsList).hasRole("USER")
				.antMatchers(userAndAminPermissionsList).hasAnyRole("USER","ADMIN")
				.anyRequest().authenticated()
				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http
				.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

		// @formatter:on
	}
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder(11);
	}

}
