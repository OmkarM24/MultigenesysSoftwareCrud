package com.example.MultigenesysSoftwareCrud.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.MultigenesysSoftwareCrud.Entity.Bookstore;
import com.example.MultigenesysSoftwareCrud.Entity.Bus;
import com.example.MultigenesysSoftwareCrud.Entity.Transactions;

@Repository
public class BookstoreDao {
	
	@Autowired
	SessionFactory sf;

	public List<Bookstore> getAllBooks() {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Bookstore.class);
		List<Bookstore> l =criteria.list();
		session.close();
		return l;
	}

	public String saveBook(Bookstore bookstore) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.save(tr);
		tr.commit();
		session.close();
		return "Book Inserted..!!";
	}

	public Bookstore getbookbyId(Long Id) {
		Session session=sf.openSession();
		Bookstore bookstore =session.get(Bookstore.class, Id);
		session.close();
		return bookstore;
	}
	
	public String updateBook(Bookstore bookstore,Long Id) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Bookstore bks=null;
		bks = session.get(Bookstore.class, Id);
		if(bks != null) {
			bks.setBookTitle(bookstore.getBookTitle());
			bks.setBookAuthor(bookstore.getBookAuthor());
			bks.setBookPrice(bookstore.getBookPrice());
			bks.setResource(bookstore.getResource());
		}
		else if(bks == null) {
			return "Book not found :"+Id;
		}
		tr.commit();
		session.close();
		return "Book Updated..!!";	
	}

	public String deleteBook(Long Id) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Bookstore bookstore = session.get(Bookstore.class, Id);
		session.delete(bookstore);
		tr.commit();
		session.close();
		return "Book Deleted..!!";
	}

	public Bookstore getbookbyResource(String resource) {
		Session session=sf.openSession();
		Bookstore bookstore =session.get(Bookstore.class, resource);
		session.close();
		return bookstore;
	}
}
