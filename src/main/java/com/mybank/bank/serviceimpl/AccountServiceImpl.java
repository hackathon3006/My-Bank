package com.mybank.bank.serviceimpl;

import org.springframework.stereotype.Service;

import com.mybank.bank.model.AccountDetailsModel;

@Service
public class AccountServiceImpl {
	
	
	public AccountDetailsModel getAccountDetails() {
		AccountDetailsModel accountDetailsModel = new AccountDetailsModel();
		
		return accountDetailsModel;
		
	}

}
