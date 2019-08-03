package com.mybank.bank.serviceimpl;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.mybank.bank.entity.Account;
import com.mybank.bank.entity.Customer;
import com.mybank.bank.exception.CustomException;
import com.mybank.bank.model.AccountDetailsModel;
import com.mybank.bank.service.CustomerService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class AccountServiceImplTest {

	@InjectMocks
	AccountServiceImpl accountServiceImpl;

	@Mock
	CustomerService customerService;

	@Test
	public void getAccountDetails(Long customerId) throws CustomException {
		Customer customer = new Customer();
		Account account = new Account();
		account.setAccountNumber(1234L);
		account.setStatus("ACTIVE");
		customer.setAccount(account);
		Mockito.when(customerService.getCustomer(1L)).thenReturn(customer);
		
		AccountDetailsModel accountDetailModel = accountServiceImpl.getAccountDetails(1L);
		assertNotNull(accountDetailModel);

	}

}
