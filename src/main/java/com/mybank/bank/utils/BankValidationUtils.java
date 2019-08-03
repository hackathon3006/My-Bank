package com.mybank.bank.utils;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mybank.bank.entity.Account;
import com.mybank.bank.entity.Transaction;
import com.mybank.bank.service.TransactionService;

@Component
public class BankValidationUtils {

	@Autowired
	TransactionService transactionService;

	public Boolean checkMinimumBalanceAndLimitBalanceForDebit(Account account, Double txnAmount) throws Exception {

		boolean BalanceAndLimitBalanceForDebit = false;

		if (account != null) {

			Double todaysSumAmount = 0d;

			LocalDateTime today = LocalDateTime.now();
			List<Transaction> transactionListByDate = transactionService.getAllBetweenDates(today, today);

			// TODO Need to use JAVA 8
			for (Transaction txn : transactionListByDate) {
				todaysSumAmount = todaysSumAmount + txn.getAmount();
			}

			// Check Limit balance for customer
			if (todaysSumAmount > account.getMinimumBalance()) {
				BalanceAndLimitBalanceForDebit = false;
				return BalanceAndLimitBalanceForDebit;
			}

			// Check whether balance available in the account for customer
			Double balance = account.getBalance();
			if (txnAmount < balance) {
				BalanceAndLimitBalanceForDebit = true;
			} else {
				throw new Exception();
			}
		}

		return BalanceAndLimitBalanceForDebit;
	}
}
