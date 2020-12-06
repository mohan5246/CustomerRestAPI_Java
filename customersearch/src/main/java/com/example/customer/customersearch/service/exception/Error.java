package com.example.customer.customersearch.service.exception;

import java.io.Serializable;

@SuppressWarnings("rawtypes")
public class Error implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2146390802157269491L;

	private String errorCode;
	private String errorMsg;
	private Class errorClass;

	public Error() {
		// TODO Auto-generated constructor stub
	}

	public Error(String errorCode, String errorMsg, Class errorClass) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.errorClass = errorClass;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Class getErrorClass() {
		return errorClass;
	}

	public void setErrorClass(Class errorClass) {
		this.errorClass = errorClass;
	}

}
