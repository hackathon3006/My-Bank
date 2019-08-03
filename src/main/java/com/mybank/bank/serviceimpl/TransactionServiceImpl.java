package com.mybank.bank.serviceimpl;

import java.sql.SQLDataException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybank.bank.entity.Account;
import com.mybank.bank.entity.Transaction;
import com.mybank.bank.exception.CustomException;
import com.mybank.bank.repository.TransactionRepository;
import com.mybank.bank.service.AccountService;
import com.mybank.bank.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	AccountService accountService;

	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public Long transfer(Long fromAccountNumber, Long toAccountNumber, Double amount, String remarks)
			throws CustomException, SQLDataException {
		Account fromAccount = accountService.getAccountByAccountNumber(fromAccountNumber);

		Account toAccount = accountService.getAccountByAccountNumber(toAccountNumber);

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

	public List<Transaction> getAllBetweenDates(LocalDateTime startDate, LocalDateTime endDate) {

		return transactionRepository.getAllBetweenDates(startDate, endDate);

	}

}
