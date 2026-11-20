package com.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Library {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int libraryId;

	private String libraryName;

	private String libraryCountry;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Lib_Book_Table" , 
	joinColumns = @JoinColumn(name = "Lib_Id"),
	inverseJoinColumns = @JoinColumn(name = "Book_Id"))
	private List<Book> listOfBooks;

	
	public int getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(int libraryId) {
		this.libraryId = libraryId;
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	public String getLibraryCountry() {
		return libraryCountry;
	}

	public void setLibraryCountry(String libraryCountry) {
		this.libraryCountry = libraryCountry;
	}

	public List<Book> getListOfBooks() {
		return listOfBooks;
	}

	public void setListOfBooks(List<Book> listOfBooks) {
		this.listOfBooks = listOfBooks;
	}

	@Override
	public String toString() {
		return "Library [libraryId=" + libraryId + ", libraryName=" + libraryName + ", libraryCountry=" + libraryCountry
				+ ", listOfBooks=" + listOfBooks + "]";
	}

}
