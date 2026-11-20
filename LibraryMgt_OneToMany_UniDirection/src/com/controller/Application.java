package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Book;
import com.entity.Library;
import com.service.LibraryMgtServiceImple;
import com.util.HibernateUtil;

public class Application {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSesstionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		LibraryMgtServiceImple ls = new LibraryMgtServiceImple();

		// AddLibAndBookInfo();

		// getListOfBooks();

		// Book deleteBookById= ls.deleteBookById(4,15);

		// ls.AddBookInExistingLibrary(1,"Hacking",333.00);
		
		// ls.updateBookById(1,1,"Yogesh",1000.00);
	}


	private static void getListOfBooks() {

		LibraryMgtServiceImple ls = new LibraryMgtServiceImple();

		ls.getListOfBooks();
	}

	private static void AddLibAndBookInfo() {
		// -------------------------------------------------
		// Create Library Object
		// -------------------------------------------------

		Library library = new Library();

		library.setLibraryName("Albert");
		library.setLibraryCountry("New York");

		// -------------------------------------------------
		// Create Book 1
		// -------------------------------------------------

		Book book = new Book();

		book.setBookName(".sql");
		book.setBookPrice(100.00);

		// -------------------------------------------------
		// Create Book 2
		// -------------------------------------------------

		Book book1 = new Book();

		book1.setBookName("postgree");
		book1.setBookPrice(50.00);

		// -------------------------------------------------
		// Add Books into List
		// -------------------------------------------------

		List<Book> listOfBooks = new ArrayList<Book>();

		listOfBooks.add(book);
		listOfBooks.add(book1);

		// -------------------------------------------------
		// Set Books into Library
		// -------------------------------------------------

		library.setListOfBooks(listOfBooks);

		// -------------------------------------------------
		// Send Library Object to Service
		// -------------------------------------------------

		LibraryMgtServiceImple ls = new LibraryMgtServiceImple();

		ls.addLibrary(library);

		System.out.println("Library and Books Saved Successfully");
	}

}
