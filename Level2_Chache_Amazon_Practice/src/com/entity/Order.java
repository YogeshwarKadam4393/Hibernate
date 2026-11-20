package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "Order_Details")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY) // This config is used to enable 2nd Level Cache
public class Order {
	
	@Id
	@Column(name = "Order_Id")
	private int oid;
	
	@Column(name= "Customer_Name",nullable = false , length = 30)
	private String cname;
	
	@Column(name ="Quantity",nullable = false)
	private int oquantity;
	
	

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getOquantity() {
		return oquantity;
	}

	public void setOquantity(int oquantity) {
		this.oquantity = oquantity;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", cname=" + cname + ", oquantity=" + oquantity + "]";
	}


}
