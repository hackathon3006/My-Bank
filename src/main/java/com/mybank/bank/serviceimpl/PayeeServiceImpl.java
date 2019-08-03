package com.mybank.bank.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybank.bank.entity.Account;
import com.mybank.bank.entity.Customer;
import com.mybank.bank.entity.Payee;
import com.mybank.bank.exception.CustomException;
import com.mybank.bank.repository.PayeeRepository;
import com.mybank.bank.service.CustomerService;
import com.mybank.bank.service.PayeeService;

@Service
public class PayeeServiceImpl implements PayeeService {

	@Autowired
	CustomerService customerService;

	@Autowired
	PayeeRepository payeeRepository;

	@Override
	public List<Payee> getPayeeByCustomerId(Long customerId) throws CustomException {

		List<Payee> findPayeeByPayerAccountId = new ArrayList<Payee>();

		Customer customer = customerService.getCustomer(customerId);

		Account account = customer.getAccount();

		Long accountId = account.getAccountId();

		findPayeeByPayerAccountId = payeeRepository.findPayeeByPayerAccountId(accountId);

		if (!findPayeeByPayerAccountId.isEmpty()) {
			return findPayeeByPayerAccountId;
		} else {
			throw new CustomException("No Beneficiary added !!!!");
		}

	}

}
