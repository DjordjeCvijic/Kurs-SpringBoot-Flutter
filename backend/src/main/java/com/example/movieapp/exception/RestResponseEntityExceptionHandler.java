package com.example.movieapp.exception;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RestResponseEntityExceptionHandler  extends ResponseEntityExceptionHandler{
	@Value("${debug.response}")
	private boolean debug;

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorMessage> notFoundExceptionHandler(NotFoundException ex, WebRequest request) {
		return errorBuilder(ex, request, ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	private ResponseEntity<ErrorMessage> errorBuilder(Exception ex, WebRequest request, String errorMessage,
			HttpStatus status) {
		ErrorMessage message = new ErrorMessage(new Date(), status.value(),
				errorMessage + (debug ? ex.getMessage() : ""), request.getDescription(false));

		return new ResponseEntity<ErrorMessage>(message, status);
	}

	@ExceptionHandler(HttpClientErrorException.BadRequest.class)
	public ResponseEntity<ErrorMessage> badRequestExceptionHandler(HttpClientErrorException.BadRequest ex, WebRequest request) {
		return errorBuilder(ex, request, ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		return new ResponseEntity<>("YOUR REQUEST PARAMS NOT MATCH!",HttpStatus.BAD_GATEWAY);
		//return super.handleHttpMessageNotReadable(ex, headers, status, request);
	}
}
