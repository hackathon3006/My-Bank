package com.mybank.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData {
   
	
	private String message;
	private int statusCode;
	private String statusDesc;
	private Object object;
	
	
}
