package com.mybank.bank.model;

import java.time.LocalDate;

import com.mybank.bank.entity.Customer;

public class AccountModel {

	private Long accountId;
	private Long accountNumber;
	private String accountType;
	private LocalDate creationDate;
	private Double balance;
	private String status;
	private Customer accountHolder;

}
