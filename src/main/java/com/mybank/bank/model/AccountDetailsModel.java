package com.mybank.bank.model;

import java.time.LocalDateTime;
import java.util.List;

import com.mybank.bank.entity.Transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDetailsModel {
	
	private Long accountNumber;
	private Double balance;
	private LocalDateTime account_creation_date;
	private List<Transaction> transactionList;

}
