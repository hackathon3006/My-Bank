package com.mybank.bank.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "account")
public class Account implements Serializable{


	private static final long serialVersionUID = 6397635543008657393L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountId;
	private Long accountNumber;
	private String accountType;
	private LocalDate creationDate;
	private Double balance;
	private String status;
	
	@OneToOne
	private Customer accountHolder;

}
