package com.mybank.bank.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class Transaction implements Serializable{

	
	private static final long serialVersionUID = -1070881664837605036L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;
	
	private Double amount;
	
	private LocalDateTime transactionDate;
	
	private String transactionType;
	
	private String status;
	
	private String remarks;
	

	private Account fromAccount;
	
	private Account toAccount;
}
