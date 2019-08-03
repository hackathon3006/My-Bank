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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table(name = "payee")

@JsonIgnoreProperties({ "customer" })
public class Payee implements Serializable {


	private static final long serialVersionUID = 4744050250625239790L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long payeeId;

	private Long payerAccountId;

	private Long payeeAccountId;

	private String status;

	@JsonProperty(value = "customer")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Customer customer;
}
