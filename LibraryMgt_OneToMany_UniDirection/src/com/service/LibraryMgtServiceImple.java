package com.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Book;
import com.entity.Library;
import com.util.HibernateUtil;

public class LibraryMgtServiceImple implements LibraryService{

	SessionFactory sf = HibernateUtil.getSesstionFactory();

	@Override
	public void addLibrary(Library library) {

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

			session.save(library);

			tx.commit();

			System.out.println("Library Added Successfully");
	}
	
	@Override
	public List<Book> getListOfBooks(){
		
		Session session = sf.openSession();
		
		Library library = session.get(Library.class, 1);
		
		List<Book> listOfbooks = library.getListOfBooks();
		
		System.out.println(listOfbooks);
		
		return listOfbooks;
		
	}
	
	@Override
	public Book deleteBookById(int libraryId,int bookId) {
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Library lib = session.get(Library.class, libraryId);
		
		Book book = null;
		
		List<Book> listOfBooks= lib.getListOfBooks();
		
		for (Book book2 : listOfBooks) {
			
			if(book2 != null && book2.getBookId()==bookId) {
				book = book2;
			}
		}

		listOfBooks.remove(book);
		
		session.delete(book);
		
		tx.commit();
		
		System.out.println("Book Deleted SuccessFully...!!");
		
		return book;
	}

	@Override
	public Library AddBookInExistingLibrary(int LibraryId,String bookName,double price) {
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Library library = session.get(Library.class, LibraryId);

		Book book = new Book();
		book.setBookName(bookName);
		book.setBookPrice(price);

		List<Book> listOfBooks = library.getListOfBooks();
		listOfBooks.add(book);

		session.save(library);

		tx.commit();
		
		System.out.println("Book Saved In Existing Library SuccessFully...!!");
		
		return library;
	}

	@Override
	public Library updateBookById(int LibraryId,int bookId,String bookName,double price) {
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Library library = session.get(Library.class, LibraryId);
		
		List<Book> books = library.getListOfBooks();
		
		Book updateBook = null;
		
		for (Book book : books) {
			
			if(books != null && book.getBookId() == bookId) {
				updateBook = book;
				break;
			}else {
				System.out.println("Book Not Available..!!");
			}
		}
		
		updateBook.setBookName(bookName);
		updateBook.setBookPrice(price);
		
		session.update(library);
		
		tx.commit();
		
		System.out.println("Book Updated Successfully...!!");
		
		return library;
	}
}