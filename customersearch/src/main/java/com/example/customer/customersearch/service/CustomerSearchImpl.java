package com.example.customer.customersearch.service;

import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

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
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error"+e.getMessage());
			return new ExceptionHandler(new Error("ERR_001", "Data Not Found")).toResponse(e);
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
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}

	}

	public Response updateCustomer(Customer customer, @PathParam("custId") String custId) {
		try {
			service = new CustomerService();
			return Response.status(Status.OK).entity(service.updateCustomerDetails(custId, customer)).build();
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
}
