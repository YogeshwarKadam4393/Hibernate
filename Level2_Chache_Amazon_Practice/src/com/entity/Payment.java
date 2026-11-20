package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "Payment_Details")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY) // This config is used to enable 2nd Level Cache
public class Payment {
	
	@Id
	@Column(name = "Txn_Id")
	private int transactionid;
	
	@Column(name= "Ammount",nullable = false)
	private double ammount;
	
	@Column(name ="Payment_Method",nullable = false)
	private String paymentMethod;
	
	

	@Override
	public String toString() {
		return "Payment [transactionid=" + transactionid + ", ammount=" + ammount + ", paymentMethod=" + paymentMethod
				+ "]";
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public int getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}

	public double getAmmount() {
		return ammount;
	}

	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}

}
