package com.mybank.bank.service;

import org.springframework.stereotype.Service;

import com.mybank.bank.entity.Account;
import com.mybank.bank.exception.CustomException;
import com.mybank.bank.model.AccountDetailsModel;
import com.mybank.bank.model.AccountSummary;

@Service
public interface AccountService 
{

	public Account getAccountByAccountNumber(Long accountNumber) throws CustomException;

	public void updateBalance(Account fromAccount);

	public AccountDetailsModel getAccountDetails(Long customerId) throws CustomException;

	public AccountSummary getAccountDetailsSummary(Long customerId);
}
