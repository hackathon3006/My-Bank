package com.mybank.bank.controller;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLDataException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.mybank.bank.exception.CustomException;
import com.mybank.bank.model.ResponseData;
import com.mybank.bank.service.TransactionService;

@RunWith(MockitoJUnitRunner.class)
public class TransactionControllerTest 
{
	@InjectMocks
	TransactionController transactionController;
	
	@Mock
	TransactionService transactionServiceMock;
	
	@Before
	public void setUp()
	{
		
	}
	
	@Test
	public void testFundTransfer() throws SQLDataException, CustomException
	{
		Mockito.when(transactionServiceMock.transfer(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyDouble(), Mockito.anyString())).thenReturn(10L);
		ResponseEntity<ResponseData> fundTransfer = (ResponseEntity<ResponseData>) transactionController.fundTransfer(11111111L, 11111122L, 500.00, "EMI");
	
		assertNotNull(fundTransfer);
	}

}
