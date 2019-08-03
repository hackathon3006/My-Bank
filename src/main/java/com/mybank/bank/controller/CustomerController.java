package com.mybank.bank.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mybank.bank.model.ResponseData;

@RestController
@CrossOrigin
public class CustomerController {

	@GetMapping
	public ResponseEntity<ResponseData> login(@RequestParam("customerId") Long customerId ,@RequestParam("password")String password){
		
		
		
		return null;
		
	}
}
