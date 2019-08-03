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
@Table(name = "customer")
public class Customer implements Serializable{

	private static final long serialVersionUID = 8376843488205294905L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	private String password;
	private String customerName;
	private LocalDate dob;
	private String email;
	private String phone;
	private String city;
	private String customerType;
	private String status;
	
	@OneToOne
	private Account account;
	

}
