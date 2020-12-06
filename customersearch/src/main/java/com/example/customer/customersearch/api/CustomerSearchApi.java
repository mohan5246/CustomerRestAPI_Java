package com.example.customer.customersearch.api;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.customer.customersearch.model.Customer;
import com.example.customer.customersearch.service.CustomerSearchImpl;

@Consumes(MediaType.APPLICATION_JSON)
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Path("/customersearchapi")
public class CustomerSearchApi extends CustomerSearchImpl {

	@GET
	@Override
	public Response getAllCustomers() throws Exception {

		return super.getAllCustomers();
	}

	@GET
	@Path("/{custId}")
	@Override
	public Response getCustomerById(@PathParam("custId") String custId) {

		return super.getCustomerById(custId);
	}

	@POST
	@Override
	public Response addCustomer(Customer customer) {
		return super.addCustomer(customer);

	}

	@DELETE
	@Path("/{custId}")
	@Override
	public Response deleteCustomer(@PathParam("custId") String custId) {

		return super.deleteCustomer(custId);
	}

	@PUT
	@Path("/{custId}")
	@Override
	public Response updateCustomer(Customer customer, @PathParam("custId") String custId) {
		// TODO Auto-generated method stub
		return super.updateCustomer(customer, custId);
	}
}
