package com.mybank.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybank.bank.model.AccountDetailsModel;
import com.mybank.bank.model.ResponseData;
import com.mybank.bank.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService accountService;

	@SuppressWarnings("unchecked")
	@GetMapping("/details")
	public ResponseEntity<ResponseData> fetchAccountDetails(@PathVariable(name = "customerId") Long customerId){
		AccountDetailsModel accountDetailsModel = accountService.getAccountDetails(customerId);

		ResponseData response = new ResponseData("", HttpStatus.OK, accountDetailsModel);

		return new ResponseEntity(HttpStatus.OK);
	}
}
