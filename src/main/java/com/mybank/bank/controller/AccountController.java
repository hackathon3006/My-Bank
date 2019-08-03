package com.mybank.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybank.bank.exception.CustomException;
import com.mybank.bank.model.AccountDetailsModel;
import com.mybank.bank.model.AccountSummary;
import com.mybank.bank.model.ResponseData;
import com.mybank.bank.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService accountService;


	@GetMapping("/details/{customerId}")
	public ResponseEntity<ResponseData> fetchAccountDetails (@PathVariable(value = "customerId") Long customerId) throws CustomException{
		AccountDetailsModel accountDetailsModel = accountService.getAccountDetails(customerId);
		if(!ObjectUtils.isEmpty(accountDetailsModel)) {
			ResponseData response = new ResponseData();
			response.setMessage("Account details are as follows: ");
			response.setObject(accountDetailsModel);
			response.setStatusCode(2000);
			response.setStatusDesc("Successfull fetching of account details.");
			return  new ResponseEntity<> (response ,HttpStatus.OK);
		} else throw new CustomException("Account details are not present.");
	}

	

	@GetMapping("/accountSummary/{customer_id}")
	public ResponseEntity<ResponseData> accountSummary(@PathVariable("customer_id")Long customerId) {

		AccountSummary accountSummary = accountService.getAccountDetailsSummary(customerId);
		
		ResponseData response = new ResponseData();
		response.setMessage("Account details are as follows: ");
		response.setObject(accountSummary);
		response.setStatusCode(2000);
		response.setStatusDesc("Successfully fetching of account details.");
		return  new ResponseEntity<> (response ,HttpStatus.OK);

	}
}
