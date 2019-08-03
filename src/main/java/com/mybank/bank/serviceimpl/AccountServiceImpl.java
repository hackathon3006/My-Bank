package com.mybank.bank.serviceimpl;

import java.sql.SQLDataException;
import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mybank.bank.entity.Account;
import com.mybank.bank.entity.Customer;
import com.mybank.bank.exception.CustomException;
import com.mybank.bank.model.AccountDetailsModel;
import com.mybank.bank.model.AccountSummary;
import com.mybank.bank.repository.AccountRepository;
import com.mybank.bank.repository.CustomerRepository;
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

	@Autowired
	CustomerRepository customerRepository;

	public AccountDetailsModel getAccountDetails(Long customerId) throws CustomException {
		AccountDetailsModel accountDetailsModel = new AccountDetailsModel();

		Customer customer = customerService.getCustomer(customerId);

		accountDetailsModel.setAccountNumber(customer.getAccount().getAccountNumber());
		accountDetailsModel.setBalance(customer.getAccount().getBalance());
		accountDetailsModel.setAccountCreationDate(customer.getAccount().getCreationDate());

		Collections.reverse(customer.getAccount().getTransactionList());
		accountDetailsModel.setTransactionList(customer.getAccount().getTransactionList().subList(0, 10));

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
		accountSummary.setCustomerName(customer.getCustomerName());
		accountSummary.setAccountNumber(customer.getAccount().getAccountNumber());
		accountSummary.setBalance(customer.getAccount().getBalance());
		accountSummary.setAccountType(customer.getAccount().getAccountType());
		return accountSummary;

	}
}
