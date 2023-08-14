package com.example.MultigenesysSoftwareCrud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MultigenesysSoftwareCrud.Entity.Bus;
import com.example.MultigenesysSoftwareCrud.Service.BusService;

@RestController
@RequestMapping("/bus")
public class BusController {
	
	@Autowired
	BusService busService;
	
	@PostMapping("/savebus")
	public String savebus(@RequestBody Bus bus) {
		return busService.savebus(bus);
	}
	
	@GetMapping("/buslist")
	public List<Bus> buslist() {
		return busService.buslist();
	}

	@PutMapping("/update/{Id}")
	public String updatebus(@RequestBody Bus bus,@PathVariable Long Id) {
		return busService.updatebus(bus, Id);
	}
	
	@DeleteMapping("/deletebus/{Id}")
	public String deletebus(@PathVariable Long Id) {
		return busService.deletebus(Id);
	}
}
