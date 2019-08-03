package com.mybank.bank.serviceimpl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybank.bank.entity.Account;
import com.mybank.bank.entity.Transaction;
import com.mybank.bank.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService 
{
	@Autowired
	AccountService accountService;

	@Override
	public Long transfer(Long fromAccountNumber, Long toAccountNumber, Double amount, String remarks) 
	{
		Account fromAccount;
		
		Account toAccount;
		
		Transaction creditTransaction = new Transaction();
		
		Transaction debitTransaction = new Transaction();
		
		creditTransaction.setAmount(amount);
		creditTransaction.setFromAccount(fromAccount);
		creditTransaction.setToAccount(toAccount);
		creditTransaction.setTransactionDate(LocalDateTime.now());
		creditTransaction.setRemarks(remarks);
		creditTransaction.setTransactionType(transactionType);
		creditTransaction.setStatus(status);
		return null;
	}

}
