package com.mybank.bank.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mybank.bank.model.ResponseData;



@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) 
	{
		List<String> errorList = new ArrayList<>();

		for(ObjectError error : ex.getBindingResult().getAllErrors())
		{
			errorList.add(error.getDefaultMessage());
		}

		ResponseData response = new ResponseData();
		response.setMessage(ex.getMessage());
		response.setStatusCode(3000);
		response.setStatusDesc("BAD_REQUEST");
		response.setObject("");

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	private List<String> seprateCodes(String message) {
		return Stream.of(message.split("-")).map(elem -> new StringBuilder(elem).toString())
				.collect(Collectors.toList());
		
	}

	@ExceptionHandler(CustomException.class)
	public final ResponseEntity<Object> handleAllExceptions(CustomException ex, WebRequest request) {

		List<String> errorList = new ArrayList<>();
		errorList.add(ex.getMessage());

		List<String> statusList = seprateCodes(ex.getMessage());
		ResponseData response = new ResponseData();
		response.setMessage(statusList.get(0));
		response.setStatusCode(Integer.valueOf(statusList.get(1)));
		response.setStatusDesc("BAD_REQUEST");
		response.setObject("");
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

	}
}
