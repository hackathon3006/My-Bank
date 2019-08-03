package com.mybank.bank.serviceimpl;


import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.mybank.bank.service.CustomerService;

public class AccountServiceImplTest {

	@InjectMocks
	AccountServiceImpl accountServiceImpl;

	@Mock
	CustomerService customerService;

	@Before
	public void setup() {

	}


	/*
	 * @Test public void getAccountDetails(Long customerId) throws CustomException {
	 * Customer customer = new Customer(); Account account = new Account();
	 * account.setAccountNumber(1234L); account.setStatus("ACTIVE");
	 * customer.setAccount(account);
	 * Mockito.when(customerService.getCustomer(1L)).thenReturn(customer);
	 * 
	 * AccountDetailsModel accountDetailModel =
	 * accountServiceImpl.getAccountDetails(1L); assertNotNull(accountDetailModel);
	 * 
	 * }
	 */


}
