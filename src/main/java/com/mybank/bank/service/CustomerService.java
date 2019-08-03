package com.mybank.bank.service;

import org.springframework.stereotype.Service;

import com.mybank.bank.entity.Customer;
import com.mybank.bank.exception.CustomException;

@Service
public interface CustomerService {

	public Customer getCustomer(Long customerId) throws CustomException;

}
