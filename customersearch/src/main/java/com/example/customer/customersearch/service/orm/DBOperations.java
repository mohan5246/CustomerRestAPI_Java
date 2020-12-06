package com.example.customer.customersearch.service.orm;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.dom.DOMNodeHelper.EmptyNodeList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.customer.customersearch.model.Customer;

public class DBOperations {

	public DBOperations() {

	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * SessionFactory sessionFactory = null; Session sessionObj = null;
	 * Transaction transaction = null; List list = null; try { sessionFactory =
	 * SessionFactoryUtil.configureSessionFactory(); sessionObj =
	 * sessionFactory.openSession(); transaction =
	 * sessionObj.beginTransaction(); list = new ArrayList<Customer>(); list =
	 * sessionObj.createQuery("FROM Customer where custId = :custid").setString(
	 * "custid", "TESTCUST01").list(); transaction.commit();
	 * System.out.println("List Size"+list.size()); } catch (Exception e) {
	 * transaction.rollback(); throw (e); } finally { if (null != sessionObj)
	 * sessionObj.close(); if (null != sessionFactory) sessionFactory.close();
	 * System.out.println("CLOSED::" + sessionFactory.isClosed() + " :::: " +
	 * sessionObj.isOpen()); SessionFactoryUtil.close(); }
	 * 
	 * }
	 */

	public boolean createRecord(Customer customer) {
		SessionFactory sessionFactory = null;
		Session sessionObj = null;
		Transaction transaction = null;
		try {

			sessionFactory = SessionFactoryUtil.configureSessionFactory();
			sessionObj = sessionFactory.openSession();
			transaction = sessionObj.beginTransaction();

			sessionObj.saveOrUpdate(customer);
			transaction.commit();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
			return false;
		} finally {
			SessionFactoryUtil.close();
		}
	}

	@SuppressWarnings("rawtypes")
	public List getAllCustomers() throws Exception {
		SessionFactory sessionFactory = null;
		Session sessionObj = null;
		Transaction transaction = null;
		List list = null;
		try {
			sessionFactory = SessionFactoryUtil.configureSessionFactory();
			sessionObj = sessionFactory.openSession();
			transaction = sessionObj.beginTransaction();
			list = new ArrayList<Customer>();
			list = sessionObj.createQuery("FROM Customer").list();
			transaction.commit();
			return list;
		} catch (Exception e) {
			transaction.rollback();
			throw (e);
		} finally {
			if (null != sessionObj)
				sessionObj.close();
			if (null != sessionFactory)
				sessionFactory.close();
			System.out.println("CLOSED::" + sessionFactory.isClosed() + " :::: " + sessionObj.isOpen());
			SessionFactoryUtil.close();
		}
	}

	public Customer deleteRecord(String customerId) throws Exception {
		SessionFactory sessionFactory = null;
		Session sessionObj = null;
		Transaction transaction = null;
		try {

			sessionFactory = SessionFactoryUtil.configureSessionFactory();
			sessionObj = sessionFactory.openSession();
			transaction = sessionObj.beginTransaction();
			Customer customer = getCustomerById(customerId);
			sessionObj.delete(customer);
			transaction.commit();

			return customer;
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			throw (e);
		} finally {
			SessionFactoryUtil.close();
		}
	}

	public Customer updateRecord(String customerId, Customer customer) {
		SessionFactory sessionFactory = null;
		Session sessionObj = null;
		Transaction transaction = null;
		try {

			sessionFactory = SessionFactoryUtil.configureSessionFactory();
			sessionObj = sessionFactory.openSession();
			transaction = sessionObj.beginTransaction();
			Customer existing_data = (Customer) sessionObj.get(Customer.class, customerId);
			System.out.println("::: Before Updating :::" + existing_data.toString());
			existing_data = customer;
			System.out.println("::: After Updating :::" + existing_data.toString());
			sessionObj.getTransaction().commit();
			//transaction.commit();

			return existing_data;
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
			return null;
		} finally {
			SessionFactoryUtil.close();
		}
	}

	public Customer getCustomerById(String custId) throws Exception {
		SessionFactory sessionFactory = null;
		Session sessionObj = null;

		try {
			sessionFactory = SessionFactoryUtil.configureSessionFactory();
			sessionObj = sessionFactory.openSession();
			sessionObj.beginTransaction();
			Customer customer = (Customer) sessionObj.load(Customer.class, custId);
			System.out.println("data" + customer.toString());
			return customer;

		} catch (Exception e) {
			throw (e);
		} finally {
			if (null != sessionObj)
				sessionObj.close();
			if (null != sessionFactory)
				sessionFactory.close();

			SessionFactoryUtil.close();
		}
	}

}
