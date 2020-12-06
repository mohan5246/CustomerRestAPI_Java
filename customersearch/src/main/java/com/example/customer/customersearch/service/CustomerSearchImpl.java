package com.example.customer.customersearch.service;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.hibernate.ObjectNotFoundException;

import com.example.customer.customersearch.constants.ActionConstants;
import com.example.customer.customersearch.model.Customer;
import com.example.customer.customersearch.service.exception.Error;
import com.example.customer.customersearch.service.exception.ExceptionHandler;

public class CustomerSearchImpl {

	CustomerService service;

	public CustomerSearchImpl() {
		// TODO Auto-generated constructor stub
	}

	public Response getAllCustomers() throws Exception {
		service = new CustomerService();

		return Response.status(Status.OK).entity(new GenericEntity<List<Customer>>(service.getAllCustomer()) {
		}).build();
	}

	public Response getCustomerById(String custId) {
		service = new CustomerService();
		try {
			return Response.status(Status.OK).entity(new GenericEntity<Customer>(service.getCustomerById(custId)) {
			}).build();
		} catch (ObjectNotFoundException ex1) {
			return new ExceptionHandler(
					new Error(ActionConstants.ERR_001, ex1.getMessage(), ObjectNotFoundException.class))
							.toResponse(ex1);
		} catch (SQLException ex2) {
			return new ExceptionHandler(
					new Error(ActionConstants.ERR_002, ex2.getMessage(), ObjectNotFoundException.class))
							.toResponse(ex2);
		}

		catch (Exception ex) {
			return new ExceptionHandler(new Error(ActionConstants.ERR_003, ex.getMessage(), java.lang.Exception.class))
					.toResponse(ex);
		}

	}

	public Response addCustomer(Customer customer) {
		service = new CustomerService();
		if (service.addCustomerData(customer))
			return Response.status(Status.OK).entity(customer).build();
		else
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();

	}

	public Response deleteCustomer(@PathParam("custId") String custId) {
		try {
			service = new CustomerService();
			return Response.status(Status.OK).entity(service.deleteCustomerDetails(custId)).build();
		} catch (ObjectNotFoundException ex1) {
			return new ExceptionHandler(
					new Error(ActionConstants.ERR_002, ex1.getMessage(), ObjectNotFoundException.class))
							.toResponse(ex1);
		} catch (SQLException ex2) {
			return new ExceptionHandler(
					new Error(ActionConstants.ERR_001, ex2.getMessage(), ObjectNotFoundException.class))
							.toResponse(ex2);
		}

		catch (Exception ex) {
			return new ExceptionHandler(new Error(ActionConstants.ERR_003, ex.getMessage(), java.lang.Exception.class))
					.toResponse(ex);
		}

	}

	public Response updateCustomer(Customer customer, @PathParam("custId") String custId) {
		try {
			service = new CustomerService();
			return Response.status(Status.OK).entity(service.updateCustomerDetails(custId, customer)).build();
		} catch (ObjectNotFoundException ex1) {
			return new ExceptionHandler(
					new Error(ActionConstants.ERR_003, ex1.getMessage(), ObjectNotFoundException.class))
							.toResponse(ex1);
		} catch (SQLException ex2) {
			return new ExceptionHandler(
					new Error(ActionConstants.ERR_002, ex2.getMessage(), ObjectNotFoundException.class))
							.toResponse(ex2);
		}

		catch (Exception ex) {
			return new ExceptionHandler(new Error(ActionConstants.ERR_001, ex.getMessage(), java.lang.Exception.class))
					.toResponse(ex);
		}
	}
}
