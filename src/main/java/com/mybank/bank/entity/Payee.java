package com.mybank.bank.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Table(name = "payee")
public class Payee implements Serializable{
	
	
	private static final long serialVersionUID = 4744050250625239790L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long payeeId;
	
	private Account payerAccountId;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Account payeeAccountId;
	
	private String status;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Customer customer;
	
	

}
