package com.mybank.bank.serviceimpl;

import java.util.Objects;
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
	
	@Override
	public String login(Long customerId,String password,String status) throws CustomException {
		Customer customer=customerRepository.findByCustomerIdAndPasswordAndStatus(customerId,password,status);
		
		if(Objects.isNull(customer)) {
			throw new CustomException("Please enter vaild credentials..",3000,"BAD_REQUEST",customerId);
		}
		
			return "Login Successfully...";
		
	}
}
