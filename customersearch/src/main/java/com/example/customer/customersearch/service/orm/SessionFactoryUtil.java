package com.example.customer.customersearch.service.orm;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.example.customer.customersearch.model.Customer;

@SuppressWarnings("deprecation")
public class SessionFactoryUtil {
	private static SessionFactory sessionFactory;
	//private static ServiceRegistry serviceRegistry;

	protected static SessionFactory configureSessionFactory() throws HibernateException {

		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		return sessionFactory;
	}

	

	

	/*public static void main(String[] args) {

		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		Customer c1 = new Customer(0001, "TEST01", "Test Name", "Bank", "Address1");

		Session session = factory.openSession();
		Transaction tx = null;
		// Integer employeeID = null;

		try {
			tx = session.beginTransaction();

			session.save(c1);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}

	}*/

	/*public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}*/

	public static void close() {
		if (sessionFactory != null) {
			sessionFactory.close();
			sessionFactory = null;
		}
	}
}
