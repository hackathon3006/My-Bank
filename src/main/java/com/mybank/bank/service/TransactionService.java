package com.mybank.bank.service;

import java.sql.SQLDataException;

import org.springframework.stereotype.Service;

import com.mybank.bank.exception.CustomException;

@Service
public interface TransactionService 
{


	Long transfer(Long fromAccountNumber, Long toAccountNumber, Double amount, String remarks) throws CustomException, SQLDataException;
	

}
