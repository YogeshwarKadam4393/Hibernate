package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Address_Details")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int aid;
	
	@Column(name= "City",nullable = false ,length = 10)
	private String acity;
	
	@Column(name ="State")
	private String astate;
	
	@Column(name = "Country")
	private String acountry;

	
	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAcity() {
		return acity;
	}

	public void setAcity(String acity) {
		this.acity = acity;
	}

	public String getAstate() {
		return astate;
	}

	public void setAstate(String astate) {
		this.astate = astate;
	}

	public String getAcountry() {
		return acountry;
	}

	public void setAcountry(String acountry) {
		this.acountry = acountry;
	}

	@Override
	public String toString() {
		return "Address [aid=" + aid + ", acity=" + acity + ", astate=" + astate + ", acountry=" + acountry + "]";
	}
	
	

}
