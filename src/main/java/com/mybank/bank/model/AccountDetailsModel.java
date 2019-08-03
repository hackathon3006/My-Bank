package com.mybank.bank.model;

import java.time.LocalDate;
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
	private LocalDate accountCreationDate;
	private List<Transaction> transactionList;

}
