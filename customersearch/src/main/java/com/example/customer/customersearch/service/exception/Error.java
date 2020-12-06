package com.example.customer.customersearch.service.exception;

import java.io.Serializable;

public class Error implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2146390802157269491L;

	private String errorCode;
	private String errorMsg;

	public Error() {
		// TODO Auto-generated constructor stub
	}

	public Error(String errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
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

	@Override
	public String toString() {
		return "Error [errorCode=" + errorCode + ", errorMsg=" + errorMsg + "]";
	}

}
