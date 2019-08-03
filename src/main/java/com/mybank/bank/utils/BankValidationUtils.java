package com.mybank.bank.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mybank.bank.entity.Account;
import com.mybank.bank.entity.Transaction;
import com.mybank.bank.exception.CustomException;
import com.mybank.bank.service.TransactionService;

@Component
public class BankValidationUtils {

	@Autowired
	TransactionService transactionService;

	public void checkMinimumBalanceAndLimitBalanceForDebit(Account account, Double txnAmount) throws CustomException {

			Double todaysSumAmount = 0d;

			LocalDateTime fromDate = LocalDate.now().atStartOfDay();
			LocalDateTime toDate = LocalDate.now().atTime(23, 59, 59);
			List<Transaction> transactionListByDate = transactionService.getAllBetweenDates(account, "DEBIT", fromDate, toDate, "ACTIVE");

			
			if(null != transactionListByDate)
			{
				for (Transaction transaction : transactionListByDate) 
				{
					todaysSumAmount = todaysSumAmount + transaction.getAmount();
				}
				
				if ((todaysSumAmount + txnAmount) > account.getTransactionLimit()) 
				{
					throw new CustomException("Exceeded Daily transaction limit-4000");
				}
				if ((account.getBalance() - txnAmount) > account.getMinimumBalance())
				{
					throw new CustomException("Insufficient Balance-4000");
				}
				
			}

	}
}
