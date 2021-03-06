package com.vsr.services.remainderapp.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class CustomisedExceptionHandler extends ResponseEntityExceptionHandler{
	
	public CustomisedExceptionHandler(){
		
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleException1(Exception ex, WebRequest request) throws Exception {
				RemainderException remainderException = new RemainderException(new Date(), ex.getMessage(),
																request.getDescription(false));
				 return new ResponseEntity<>(remainderException, HttpStatus.NOT_FOUND);
		
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		RemainderException remainderException = new RemainderException(new Date(), "Validation failed",
				ex.getBindingResult().toString());
		return new ResponseEntity<>(remainderException, HttpStatus.BAD_REQUEST);
	}
}
