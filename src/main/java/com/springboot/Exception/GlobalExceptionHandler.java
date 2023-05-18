package com.springboot.Exception;

import java.util.Date;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


public class GlobalExceptionHandler {
	
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(DataNotFoundException ex,WebRequest request)
	{
		ErrorDetails errorDetails=new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
  public Exceptiondetails exception(MethodArgumentNotValidException val)
  {
      
		Exceptiondetails error=new Exceptiondetails();
      val.getBindingResult().getAllErrors().forEach(e->{
      int errcode=HttpStatus.BAD_REQUEST.value();
      error.setErrorcode(errcode);
      String errmsg=e.getDefaultMessage();
      error.setErrormsg(errmsg);
              
      });
      return error;
  }
	
	
	@ExceptionHandler(ConstraintViolationException.class)
  public Exceptiondetails exception(ConstraintViolationException val)
  {
		Exceptiondetails error=new Exceptiondetails();
	      val.getConstraintViolations().forEach(e->{
	      int errcode=HttpStatus.BAD_REQUEST.value();
	      error.setErrorcode(errcode);
	      String errmsg=e.getMessage();
	      error.setErrormsg(errmsg);
      });
      return error;
  }
}
