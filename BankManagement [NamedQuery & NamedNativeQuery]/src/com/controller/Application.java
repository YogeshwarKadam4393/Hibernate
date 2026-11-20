package com.controller;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Bank;
import com.util.HibernateUtil;

public class Application {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionfactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		
		// 1. To Fetch All Banks
		Query query = session.createNamedQuery("findAllBanks");
		List<Bank> listOfbanks = query.getResultList();
		
		for (Bank bank : listOfbanks) {
			System.out.println(bank);
		}
		
		System.out.println("-----------------------------------------------------------------------------");
		
		// 2. To Find Bank By Id
		Query query1 = session.createNamedQuery("findBankById");
		query1.setParameter("inputId", 1);
		Bank bank = (Bank) query1.getSingleResult();
		System.out.println(bank);
		
		System.out.println("-----------------------------------------------------------------------------");

		// 3. To Find Bank by Name
		Query query2 = session.createNamedQuery("findBankByName");
		query2.setParameter("inputBankName", "HDFC");
		Bank bank1 = (Bank) query2.getSingleResult();
		System.out.println(bank1);
		
		System.out.println("-----------------------------------------------------------------------------");

		// 4. To Fetch All Banks Using Named Native Query
		Query query3 = session.createNamedQuery("getAllBanks");
		List<Bank> listOfbanksUsingNamedNativeQuery = query3.getResultList();
		
		for (Bank bank5 : listOfbanksUsingNamedNativeQuery) {
			System.out.println(bank5);
		}
		
//		Bank bank = new Bank();
//		bank.setBankName("HDFC");
//		bank.setIfsc("HDFC1234");
//		bank.setBranchAddress("PUNE");
//		
//		session.save(bank);
		
		tx.commit();
		
		

	}



}
