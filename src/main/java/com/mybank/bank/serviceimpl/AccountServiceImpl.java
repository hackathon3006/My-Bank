package com.mybank.bank.serviceimpl;

import java.sql.SQLDataException;
import java.util.Optional;
import java.util.Collections;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybank.bank.entity.Account;
import com.mybank.bank.exception.CustomException;
import com.mybank.bank.model.AccountDetailsModel;
import com.mybank.bank.model.AccountSummary;
import com.mybank.bank.repository.AccountRepository;
import com.mybank.bank.repository.CustomerRepository;
import com.mybank.bank.service.AccountService;
import com.mybank.bank.entity.Customer;
import com.mybank.bank.model.AccountDetailsModel;
import com.mybank.bank.service.AccountService;
import com.mybank.bank.service.CustomerService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	AccountService accountService;

	@Autowired
	CustomerService customerService;
	
	CustomerRepository customerRepository;

	public AccountDetailsModel getAccountDetails(Long customerId) throws CustomException {
		AccountDetailsModel accountDetailsModel = new AccountDetailsModel();

		Customer customer = customerService.getCustomer(customerId);

		accountDetailsModel.setAccountNumber(customer.getAccount().getAccountNumber());
		accountDetailsModel.setBalance(customer.getAccount().getBalance());
		accountDetailsModel.setAccountCreationDate(customer.getAccount().getCreationDate());
		Collections.reverse(customer.getAccount().getTransactionList());
		//accountDetailsModel.setTransactionList(List<Transaction> Collections.reverse(customer.getAccount().getTransactionList()));
		return accountDetailsModel;

	}

	@Override
	public Account getAccountByAccountNumber(Long accountNumber) throws CustomException {

		Optional<Account> findByAccountNumberOptional = accountRepository.findByAccountNumberAndStatus(accountNumber, "ACTIVE");

		boolean isOptionalPresent = findByAccountNumberOptional.isPresent();

		if(isOptionalPresent)
			return findByAccountNumberOptional.get();
		else
			throw new CustomException("The Account does Not exist-5000");

	}

	@Override
	public void updateBalance(Account account)throws SQLDataException {
		accountRepository.save(account);
	}

	@Override
	public AccountSummary getAccountDetailsSummary(Long customerId) {

		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		AccountSummary accountSummary = new AccountSummary();
		Customer customer = optionalCustomer.get();
		BeanUtils.copyProperties(customer, accountSummary);
		return accountSummary;

	}
}
