package com.mybank.bank.serviceimpl;

import java.sql.SQLDataException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybank.bank.entity.Account;
import com.mybank.bank.exception.CustomException;
import com.mybank.bank.model.AccountDetailsModel;
import com.mybank.bank.repository.AccountRepository;
import com.mybank.bank.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	public AccountDetailsModel getAccountDetails() {
		AccountDetailsModel accountDetailsModel = new AccountDetailsModel();
		
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

}
