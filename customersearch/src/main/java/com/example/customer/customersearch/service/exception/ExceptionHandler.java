package com.example.customer.customersearch.service.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

public class ExceptionHandler extends Throwable implements ExceptionMapper<Throwable> {

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
