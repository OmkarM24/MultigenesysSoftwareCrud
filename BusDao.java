package com.example.MultigenesysSoftwareCrud.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.MultigenesysSoftwareCrud.Entity.Bus;
import com.example.MultigenesysSoftwareCrud.Entity.Project;

@Repository
public class BusDao {
	
	@Autowired
	SessionFactory sf;
	
	public String saveBus(Bus bus) {
		Session session=sf.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(transaction);
		transaction.commit();
		session.close();
		return "Bus Data Inserted..!!";
	}
	
	public List<Bus> buslist() {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Bus.class);
		List<Bus> l =criteria.list();
		session.close();
		return l;
	}
	
	public String updatebus(Bus bus,Long Id) {
		Session session=sf.openSession();
		Transaction transaction=session.beginTransaction();
		Bus bs=null;
		bs = session.get(Bus.class, Id);
		if(bs != null) {
			bs.setBusName(bus.getBusName());
		    bs.setDestination(bus.getDestination());
		    bs.setBusType(bus.getBusType());
		    bs.setDepartureTime(bus.getDepartureTime());
		    bs.setArrivalTime(bus.getArrivalTime());
		    bs.setTotalSeat(bus.getTotalSeat());
		    bs.setPrice(bus.getPrice());
		}
		else if(bs == null) {
			return "Bus not found :"+Id;
		}
		transaction.commit();
		session.close();
		return "Bus Updated..!!";	
	}
	
	public String deletebus(Long Id) {
		Session session=sf.openSession();
		Transaction transaction=session.beginTransaction();
		Bus bus = session.get(Bus.class, Id);
		session.delete(bus);
		transaction.commit();
		session.close();
		return "Bus Deleted..!!";
	}

}
