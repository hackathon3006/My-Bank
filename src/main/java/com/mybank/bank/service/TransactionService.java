package com.mybank.bank.service;

import java.sql.SQLDataException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mybank.bank.entity.Transaction;
import com.mybank.bank.exception.CustomException;

@Service
public interface TransactionService {
	
	Long transfer(Long fromAccountNumber, Long toAccountNumber, Double amount, String remarks) throws CustomException, SQLDataException;
	public List<Transaction> getAllBetweenDates(LocalDateTime startDate, LocalDateTime endDate);
	

}
