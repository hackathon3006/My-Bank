package com.mybank.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybank.bank.entity.Payee;
import com.mybank.bank.exception.CustomException;
import com.mybank.bank.model.ResponseData;
import com.mybank.bank.service.PayeeService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/payee")
public class PayeeController {

	@Autowired
	PayeeService payeeService;

	@GetMapping("/{customerId}")
	public ResponseEntity<ResponseData> payee(@PathVariable("customerId") Long customerId) throws CustomException {
		
		List<Payee> payee = payeeService.getPayeeByCustomerId(customerId);
		ResponseData response = new ResponseData();
		response.setMessage("Below are the list of Payee :");
		response.setStatusCode(2000);
		response.setStatusDesc("SUCCESSFUL");
		response.setObject(payee);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
