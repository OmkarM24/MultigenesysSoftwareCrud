package com.example.MultigenesysSoftwareCrud.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MultigenesysSoftwareCrud.Dao.BusDao;
import com.example.MultigenesysSoftwareCrud.Entity.Bus;

@Service
public class BusService {
	
	@Autowired
	BusDao busDao;
	
	public String savebus(Bus bus) {
		return busDao.saveBus(bus);
	}
	
	public List<Bus> buslist() {
		return busDao.buslist();
	}

	public String updatebus(Bus bus,Long Id) {
		return busDao.updatebus(bus, Id);
	}
	
	public String deletebus(Long Id) {
		return busDao.deletebus(Id);
	}
}
