package com.mybank.bank.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

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

			LocalDateTime fromDate = LocalDateTime.of(LocalDate.now(), LocalTime.of(0, 0, 0));
			LocalDateTime toDate = LocalDateTime.of(LocalDate.now(), LocalTime.of(23, 59, 59));
			List<Transaction> transactionList = transactionService.getAllBetweenDates(account,"DEBIT",fromDate, toDate);
					
			if(null != transactionList)
			{
				for (Transaction transaction : transactionList) 
				{
					todaysSumAmount = todaysSumAmount + transaction.getAmount();
				}
				
				if ((todaysSumAmount + txnAmount) > account.getTransactionLimit()) 
				{
					throw new CustomException("Exceeded Daily transaction limit-4000");
				}
				if ((account.getBalance() - txnAmount) < account.getMinimumBalance())
				{
					throw new CustomException("Insufficient Balance-4000");
				}
				
			}

	}
}
