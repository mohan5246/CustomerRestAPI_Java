package com.example.customer.customersearch.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "cust")
@XmlRootElement
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2696647194203576616L;

	/**
	 * 
	 */

	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy=GenerationType.TABLE, generator="keys_gen")
	 * 
	 * @TableGenerator(name="keys_gen",table="auto_keys",schema="testdb",
	 * allocationSize=1) private int key97;
	 */
	@Id
	private String custId;
	private String custName;
	private String custType;
	private String custAddr;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String custId, String custName, String custType, String custAddr) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custType = custType;
		this.custAddr = custAddr;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getCustAddr() {
		return custAddr;
	}

	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custType=" + custType + ", custAddr="
				+ custAddr + "]";
	}

}
