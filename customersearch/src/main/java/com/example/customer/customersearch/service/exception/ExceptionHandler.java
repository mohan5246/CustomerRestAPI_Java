package com.example.customer.customersearch.service.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import com.example.customer.customersearch.constants.ActionConstants;

public class ExceptionHandler extends Throwable implements ExceptionMapper<Throwable> {

	public ExceptionHandler() {
		this.error = new Error(ActionConstants.ERR_003, "Generic Error", java.lang.Exception.class);
		// TODO Auto-generated constructor stub
	}

	public ExceptionHandler(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public ExceptionHandler(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public ExceptionHandler(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public ExceptionHandler(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2152314364286692714L;
	private Error error;

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	public ExceptionHandler(Error error) {
		this.error = error;
	}

	@Override
	public Response toResponse(Throwable arg0) {
		// TODO Auto-generated method stub
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(getError()).build();
	}

}
