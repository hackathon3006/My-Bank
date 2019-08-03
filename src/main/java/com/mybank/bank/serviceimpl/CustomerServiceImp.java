package com.mybank.bank.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybank.bank.entity.Customer;
import com.mybank.bank.exception.CustomException;
import com.mybank.bank.repository.CustomerRepository;
import com.mybank.bank.service.CustomerService;

@Service
public class CustomerServiceImp implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer getCustomer(Long customerId) throws CustomException {

		Optional<Customer> customerOptional = customerRepository.findById(customerId);

		if(customerOptional.isPresent()) {
			Customer customer = customerOptional.get();
			return customer;
		} else throw new CustomException("Customer not found.");		
	}
}
