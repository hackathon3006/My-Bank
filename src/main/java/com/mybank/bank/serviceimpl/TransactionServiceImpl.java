package com.mybank.bank.serviceimpl;

import java.sql.SQLDataException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybank.bank.entity.Account;
import com.mybank.bank.entity.Transaction;
import com.mybank.bank.exception.CustomException;
import com.mybank.bank.repository.TransactionRepository;
import com.mybank.bank.service.AccountService;
import com.mybank.bank.service.TransactionService;
import com.mybank.bank.utils.BankValidationUtils;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	AccountService accountService;

	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	BankValidationUtils bankValidationUtils;

	@Override
	@Transactional
	public Long transfer(Long fromAccountNumber, Long toAccountNumber, Double amount, String remarks) throws CustomException, SQLDataException 
	{
		
		if(amount <= 0)
			throw new CustomException("Transaction Amount should be greater than 0-4000");
		
		Account fromAccount= accountService.getAccountByAccountNumber(fromAccountNumber);
		
		Account toAccount = accountService.getAccountByAccountNumber(toAccountNumber);
		bankValidationUtils.checkMinimumBalanceAndLimitBalanceForDebit(fromAccount, amount);

		Transaction creditTransaction = new Transaction();

		Transaction debitTransaction = new Transaction();

		creditTransaction.setAmount(amount);
		creditTransaction.setFromAccount(fromAccount);
		creditTransaction.setToAccount(toAccount);
		creditTransaction.setTransactionDate(LocalDateTime.now());
		creditTransaction.setRemarks(remarks);
		creditTransaction.setTransactionType("CREDIT");
		creditTransaction.setStatus("COMPLETE");

		debitTransaction.setAmount(amount);
		debitTransaction.setFromAccount(fromAccount);
		debitTransaction.setToAccount(toAccount);
		debitTransaction.setTransactionDate(LocalDateTime.now());
		debitTransaction.setRemarks(remarks);
		debitTransaction.setTransactionType("DEBIT");
		debitTransaction.setStatus("COMPLETE");

		fromAccount.setBalance(fromAccount.getBalance() - amount);

		toAccount.setBalance(toAccount.getBalance() + amount);

		Transaction debitedTransaction = transactionRepository.save(debitTransaction);
		transactionRepository.save(creditTransaction);

		accountService.updateBalance(fromAccount);
		accountService.updateBalance(toAccount);

		return debitedTransaction.getTransactionId();
	}

	
	  public List<Transaction> getAllBetweenDates(Account fromAccount, String
	  transactionType, LocalDateTime fromDate, LocalDateTime toDate)
	  {
	  
	  List<Transaction> transactionList= null; Optional<List<Transaction>>
	  optionalList = transactionRepository.getTodaysTransactionList(fromAccount,transactionType, fromDate, toDate);
	  
	  boolean isOptionalPresent = optionalList.isPresent();
	  
	  if(isOptionalPresent) transactionList = optionalList.get();
	  
	  return transactionList; 
	  }
	 

}
