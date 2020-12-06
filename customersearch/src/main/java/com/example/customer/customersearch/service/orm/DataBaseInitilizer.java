package com.example.customer.customersearch.service.orm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DataBaseInitilizer {
	static Session sessionObj;
	static SessionFactory sessionFactoryObj;
	static Configuration configObj;

	/*protected static SessionFactory buildSessionFactory() {
		// Creating Configuration Instance & Passing Hibernate Configuration
		// File
		
		configObj = new Configuration();
		configObj.configure("hibernate.cfg.xml");

		// Since Hibernate Version 4.x, ServiceRegistry Is Being Used
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
				.applySettings(configObj.getProperties()).build();

		// Creating Hibernate SessionFactory Instance
		sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
		return sessionFactoryObj;

	}*/
	
	protected static SessionFactory buildSessionFactory() {
	    try {
	        // Create the SessionFactory from hibernate.cfg.xml
	    	Configuration configuration = new Configuration();
	    	configuration.configure("hibernate.cfg.xml");
	    	System.out.println("Hibernate Configuration loaded");
	    	
	    	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	    	System.out.println("Hibernate serviceRegistry created");
	    	
	    	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    	
	        return sessionFactory;
	    }
	    catch (Throwable ex) {
	        System.err.println("Initial SessionFactory creation failed." + ex);
	        ex.printStackTrace();
	        throw new ExceptionInInitializerError(ex);
	    }
	}

	protected static void closeConnection() {
		try{
			if (null != sessionObj)
				sessionObj.close();
			
			if (null != sessionFactoryObj)
				sessionFactoryObj.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
