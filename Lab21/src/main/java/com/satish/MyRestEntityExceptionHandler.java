package com.satish;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.satish.exception.CityNotFoundException;
import com.satish.exception.CustomerIDNotFoundException;
import com.satish.exception.InvalidPhoneNumberException;
import com.satish.exception.MyCustomErrorResponse;

@ControllerAdvice
public class MyRestEntityExceptionHandler extends ResponseEntityExceptionHandler{


	@ExceptionHandler({CustomerIDNotFoundException.class})
	public void handleCidNotFound(HttpServletResponse response) throws IOException {
		response.sendError(898089);
	}

	@ExceptionHandler({InvalidPhoneNumberException.class})
	public void handlePhoneNotFound(HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value());
	}

	@ExceptionHandler({CityNotFoundException.class})
	public void handleCityNotFound(HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.NOT_FOUND.value());
	}

	@ExceptionHandler({CustomerIDNotFoundException.class,InvalidPhoneNumberException.class})
	public ResponseEntity<MyCustomErrorResponse> handleCidNotFound(){
		MyCustomErrorResponse errors = new MyCustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError("MyCustomer Id it Not Avaible...");
		errors.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({ InvalidPhoneNumberException.class})
	public ResponseEntity<MyCustomErrorResponse> handlePhoneNotFound(RuntimeException ex,
			WebRequest request) {
		MyCustomErrorResponse errors = new MyCustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(" Phone Number is Not Available");
		errors.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
	} 

	@ExceptionHandler({ CityNotFoundException.class})
	public ResponseEntity<MyCustomErrorResponse> handleCityNotFound(RuntimeException ex,
			WebRequest request) {
		MyCustomErrorResponse errors = new MyCustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(" City Not Found in DB");
		errors.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
	}
}
