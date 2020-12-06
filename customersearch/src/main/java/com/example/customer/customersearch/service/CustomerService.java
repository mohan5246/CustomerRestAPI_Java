package com.example.customer.customersearch.service;

import java.util.ArrayList;
import java.util.List;

import com.example.customer.customersearch.model.Customer;
import com.example.customer.customersearch.service.orm.DBOperations;

public class CustomerService {

	DBOperations dbOperations;

	public CustomerService() {
		if (null == list)
			list = new ArrayList<Customer>();

	}

	private static List<Customer> list;

	public static List<Customer> getList() {

		return list;
	}

	public static void setList(List<Customer> list) {
		CustomerService.list = list;
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomer() throws Exception {
		dbOperations = new DBOperations();
		setList(dbOperations.getAllCustomers());
		return getList();

	}

	public Customer getCustomerById(String custId) throws Exception{
		dbOperations = new DBOperations();
		return dbOperations.getCustomerById(custId);
	}

	public boolean addCustomerData(Customer customer) {

		dbOperations = new DBOperations();
		boolean res = dbOperations.createRecord(customer);

		return res;
	}

	public Customer deleteCustomerDetails(String custId) throws Exception {
		dbOperations = new DBOperations();
		return dbOperations.deleteRecord(custId);

	}

	public Customer updateCustomerDetails(String custId, Customer customer) throws Exception {
		dbOperations = new DBOperations();
		return dbOperations.updateRecord(custId, customer);

	}
}
