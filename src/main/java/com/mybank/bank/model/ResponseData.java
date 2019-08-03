package com.mybank.bank.model;

import lombok.Data;

@Data
public class ResponseData {
   
	private String message;
	private int statusCode;
	private String statusDesc;
	private Object object;
}
