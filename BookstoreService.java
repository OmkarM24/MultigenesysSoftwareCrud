package com.example.MultigenesysSoftwareCrud.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MultigenesysSoftwareCrud.Dao.BookstoreDao;
import com.example.MultigenesysSoftwareCrud.Entity.Bookstore;

@Service
public class BookstoreService {
	
	@Autowired
	BookstoreDao bookstoreDao;
	
	public List<Bookstore> getAllBooks(){
		return bookstoreDao.getAllBooks();
	}
	
	public String saveBook(Bookstore bookstore) {
		return bookstoreDao.saveBook(bookstore);
	}
	
	public Bookstore getbookbyId(Long Id) {
		return bookstoreDao.getbookbyId(Id);
	}
	
	public String updateBook(Bookstore bookstore,Long Id) {
		return bookstoreDao.updateBook(bookstore, Id);
	}
	
	public String deleteBook(Long Id) {
		return bookstoreDao.deleteBook(Id);
	}
	
	public Bookstore getbookbyResource(String resource) {
		return bookstoreDao.getbookbyResource(resource);
	}

}
