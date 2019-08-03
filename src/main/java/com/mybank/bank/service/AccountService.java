package com.mybank.bank.service;

import java.sql.SQLDataException;

import org.springframework.stereotype.Service;
import com.mybank.bank.model.AccountDetailsModel;

import com.mybank.bank.entity.Account;
import com.mybank.bank.exception.CustomException;

@Service
public interface AccountService 
{
	
	public Account getAccountByAccountNumber(Long accountNumber) throws CustomException;

	public void updateBalance(Account fromAccount) throws SQLDataException;
	
	public AccountDetailsModel getAccountDetails(Long customerId) throws CustomException;
}
