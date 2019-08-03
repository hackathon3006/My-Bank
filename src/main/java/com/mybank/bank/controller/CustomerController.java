package com.mybank.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mybank.bank.exception.CustomException;
import com.mybank.bank.model.ResponseData;
import com.mybank.bank.service.CustomerService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping("/login")
	public ResponseEntity<ResponseData> login(@RequestParam("customerId") Long customerId,
			@RequestParam("password") String password) throws CustomException {
		String message = customerService.login(customerId, password, "ACTIVE");
		ResponseData response = new ResponseData();
		response.setMessage(message);
		response.setStatusCode(2000);
		response.setStatusDesc("SUCCESSFUL");
		response.setObject(customerId);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}
