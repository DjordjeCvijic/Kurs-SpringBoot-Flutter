package com.security.jdbc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

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
}
