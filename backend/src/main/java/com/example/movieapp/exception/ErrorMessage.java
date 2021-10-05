package com.example.movieapp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ErrorMessage {
	private Date timestamp;
	private int status;
	private String error;
	private String path;
}