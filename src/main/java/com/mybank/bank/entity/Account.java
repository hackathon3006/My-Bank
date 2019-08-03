package com.mybank.bank.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "account")
@JsonIgnoreProperties({ "transactionList" })
public class Account implements Serializable {

	private static final long serialVersionUID = 6397635543008657393L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountId;
	private Long accountNumber;
	private String accountType;
	private LocalDate creationDate;
	private Double balance;
	private String status;
	private Double minimumBalance;
	private Double transactionLimit;

	
	@JsonProperty(value = "transactionList")
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "fromAccount")
	List<Transaction> transactionList;

}
