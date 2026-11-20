package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Passport{

	@Id
	@GeneratedValue (strategy =  GenerationType.IDENTITY)
	private int passportId;
	
	private String passportnumber;
	
	private String passportcountry;

	
	
	public int getPassportId() {
		return passportId;
	}

	public void setPassportId(int passportId) {
		this.passportId = passportId;
	}

	public String getPassportnumber() {
		return passportnumber;
	}

	public void setPassportnumber(String passportnumber) {
		this.passportnumber = passportnumber;
	}

	public String getPassportcountry() {
		return passportcountry;
	}

	public void setPassportcountry(String passportcountry) {
		this.passportcountry = passportcountry;
	}

	@Override
	public String toString() {
		return "Passport [passportId=" + passportId + ", passportnumber=" + passportnumber + ", passportcountry="
				+ passportcountry + "]";
	}

	
}
