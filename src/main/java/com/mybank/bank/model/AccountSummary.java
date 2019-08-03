package com.mybank.bank.model;


import com.mybank.bank.entity.Customer;

import lombok.Data;

@Data
public class AccountSummary {

	private String customerName;
	private String accountType;
	private Long accountNumber;
	private Double balance;
	private Customer customer;
}
