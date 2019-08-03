package com.mybank.bank.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.mybank.bank.entity.Customer;
import com.mybank.bank.model.AccountSummary;
import com.mybank.bank.model.ResponseData;
import com.mybank.bank.serviceimpl.AccountServiceImpl;



@RunWith(MockitoJUnitRunner.class)
public class TestAccountController {
     
	@InjectMocks
	AccountController accountController;
	
	@Mock
	AccountServiceImpl accountService;
	
	AccountSummary accountSummary;
	Customer customer;
	
	@Before
	public void setup() {
		
		customer=new Customer();
		customer.setCustomerName("Mansi");
		accountSummary=new AccountSummary();
		accountSummary.setAccountNumber(123345L);
		accountSummary.setAccountType("saving");
		accountSummary.setBalance(1234.5);
		accountSummary.setCustomer(customer);
		accountSummary.setCustomerName("Mansi");
	}
	
	@Test
	public void testAccountSummary() {
		Mockito.when(accountService.getAccountDetailsSummary(1234L)).thenReturn(accountSummary);
		ResponseEntity<ResponseData> response=accountController.accountSummary(1234L);
		assertNotNull(response);
		assertEquals(200,response.getStatusCodeValue());
	}
	
}
