package com.mybank.bank.service;

import org.springframework.stereotype.Service;

@Service
public interface TransactionService 
{


	Long transfer(Long fromAccountNumber, Long toAccountNumber, Double amount, String remarks);
	

}
