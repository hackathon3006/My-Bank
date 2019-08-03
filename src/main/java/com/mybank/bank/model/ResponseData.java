package com.mybank.bank.model;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ResponseData {
   
	public ResponseData(String string, HttpStatus ok, AccountDetailsModel accountDetailsModel) {
		// TODO Auto-generated constructor stub
	}
	private String message;
	private int statusCode;
	private String statusDesc;
	private Object object;
}
