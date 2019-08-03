package com.mybank.bank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mybank.bank.entity.Payee;
import com.mybank.bank.exception.CustomException;

@Service
public interface PayeeService {
	
	public List<Payee> getPayeeByCustomerId(Long customerId) throws CustomException;

}
