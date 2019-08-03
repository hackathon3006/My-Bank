package com.mybank.bank.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybank.bank.entity.Payee;
import com.mybank.bank.repository.PayeeRepository;

@Service
public class PayeeServiceImpl {
	
	@Autowired
	PayeeRepository payeeRepository;
	
	
	public List<Payee> getPayeeByCustomerId(Long customerId){
		
		return null;
		
	}

}
