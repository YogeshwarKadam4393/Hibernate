package com.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@NamedQueries({
	@NamedQuery (name = "findAllBanks" , query = "from Bank"),
	@NamedQuery(name = "findBankByName" , query = "from Bank where bankName = :inputBankName "),
	@NamedQuery(name = "findBankById" , query = "from Bank where bankId = :inputId"),
})
@NamedNativeQuery(name = "getAllBanks" , query = "select * from Bank", resultClass = Bank.class)
public class Bank {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bankId;

	private String bankName;

	private String ifsc;

	private String branchAddress;

	@CreationTimestamp // to get date
	private LocalDate createDate;

	
	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", bankName=" + bankName + ", ifsc=" + ifsc + ", branchAddress="
				+ branchAddress + ", createDate=" + createDate + "]";
	}

}
