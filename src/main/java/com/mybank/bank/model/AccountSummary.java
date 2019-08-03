package com.mybank.bank.model;

import java.time.LocalDate;

import com.mybank.bank.entity.Customer;

import lombok.Data;

@Data
public class AccountSummary {

	private String accountType;
	private LocalDate creationDate;
	private Double balance;
	private Customer customer;
}
