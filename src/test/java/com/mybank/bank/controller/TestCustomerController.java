package com.mybank.bank.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.mybank.bank.exception.CustomException;
import com.mybank.bank.model.ResponseData;
import com.mybank.bank.serviceimpl.CustomerServiceImp;

@RunWith(MockitoJUnitRunner.class)
public class TestCustomerController {
	
	@InjectMocks
	CustomerController customerController;
	
	@Mock
	CustomerServiceImp customerService;
	
	
	@Test
	public void testLogin() throws CustomException {
		Long customerId=12345L;
		String password="password";
		Mockito.when(customerService.login(customerId,password,"ACTIVE")).thenReturn("Login Successfully..");
		ResponseEntity<ResponseData> response=customerController.login(customerId, password);
		assertNotNull(response);
		assertEquals(200,response.getStatusCodeValue());
		
	}
	
	

}
