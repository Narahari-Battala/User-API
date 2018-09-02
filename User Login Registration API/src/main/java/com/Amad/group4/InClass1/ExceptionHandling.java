package com.Amad.group4.InClass1;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class ExceptionHandling extends ResponseEntityExceptionHandler {
	
@ExceptionHandler(UserNotFoundException.class)
public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
	
   ExceptionResponse exception = new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
   
   return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
   
}

@ExceptionHandler(UserAlreadyExists.class)
public final ResponseEntity<Object> handleUserAlreadyExistsException(Exception ex, WebRequest request) throws Exception {
	
   ExceptionResponse exception = new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
   
   return new ResponseEntity<>(exception, HttpStatus.CONFLICT);
   
}

@ExceptionHandler(NoRequiredContent.class)
public final ResponseEntity<Object> handleNoContentException(Exception ex, WebRequest request) throws Exception {
	
   ExceptionResponse exception = new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
   
   return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
   
}

@ExceptionHandler(Exception.class)

public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
	
	   ExceptionResponse exception = new ExceptionResponse(new Date(),"Request has empty body or exception occured",request.getDescription(false));
	   
	   return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
	   
	}
}
