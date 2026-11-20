package com.service;

import java.util.List;

import com.entity.Book;
import com.entity.Library;

public interface LibraryService {
	
	public void addLibrary(Library library);
	
	public List<Book> getListOfBooks();
	
	public Book deleteBookById(int libraryId,int bookId);
	
	public Library AddBookInExistingLibrary(int LibraryId,String bookName,double price);
	
	public Library updateBookById(int LibraryId,int bookId,String bookName,double price);

}
