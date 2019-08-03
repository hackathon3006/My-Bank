package com.mybank.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mybank.bank.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController 
{
	
	@Autowired
	TransactionService transactionService;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@PostMapping("/transfer")
	public ResponseEntity<?> fundTransfer(@RequestParam("fromAccountNumber") Long fromAccountNumber,
			@RequestParam("toAccountNumber") Long toAccountNumber,
			@RequestParam("amount") Double amount,@RequestParam("remarks") String remarks)
	{
		Long transactionId = transactionService.transfer(fromAccountNumber, toAccountNumber, amount);
		return null;
		
	}

}
