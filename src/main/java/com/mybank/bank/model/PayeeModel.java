package com.mybank.bank.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mybank.bank.entity.Customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class PayeeModel implements Serializable {

	private static final long serialVersionUID = -6736823954410189925L;

	private Long payeeId;

	private Long payerAccountId;

	private Long payeeAccountId;

	private String status;

	private Customer customer;

}
