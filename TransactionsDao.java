package com.example.MultigenesysSoftwareCrud.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.MultigenesysSoftwareCrud.Entity.Bus;
import com.example.MultigenesysSoftwareCrud.Entity.Transactions;

@Repository
public class TransactionsDao {

	@Autowired
	SessionFactory sf;

	public String saveTransactions(Transactions transactions) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.save(tr);
		tr.commit();
		session.close();
		return "Data Inserted..!!";
	}

	public List<Transactions> getAllTrsansactions() {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Transactions.class);
		List<Transactions> l =criteria.list();
		session.close();
		return l;
	}

	public String updateTransactions(Transactions transactions,Long Id) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Transactions ts=null;
		ts = session.get(Transactions.class, Id);
		if(ts != null) {
			ts.setUserName(transactions.getUserName());
			ts.setEmail(transactions.getEmail());
			ts.setBusId(transactions.getBusId());
			ts.setBusName(transactions.getBusName());
			ts.setNoOfSeat(transactions.getNoOfSeat());
			ts.setPricePerSeat(transactions.getPricePerSeat());
			ts.setTotal(transactions.getTotal());
			ts.setDate(transactions.getDate());
		}
		else if(ts == null) {
			return "Transactions not found :"+Id;
		}
		tr.commit();
		session.close();
		return "Transactions Updated..!!";	
	}

	public String deleteTransactions(Long Id) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Bus bus = session.get(Bus.class, Id);
		session.delete(bus);
		tr.commit();
		session.close();
		return "Transactions Deleted..!!";
	}

}
