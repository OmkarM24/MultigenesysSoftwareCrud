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

import com.example.MultigenesysSoftwareCrud.Entity.Transactions;
import com.example.MultigenesysSoftwareCrud.Service.TransactionsService;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {

	
	@Autowired
	TransactionsService transactionsService;
	
	@PostMapping("/save")
	public String saveTransction(@RequestBody Transactions transactions) {
		return transactionsService.saveTransaction(transactions);
	}
	
	@GetMapping("/getAll")
	public List<Transactions> getAlltransaction() {
		return transactionsService.getAlltransaction();
	}
	
	@PutMapping("/update/{Id}")
	public String updateTransaction(@RequestBody Transactions transactions,@PathVariable Long Id) {
		return transactionsService.updateTransaction(transactions, Id);
	}
	
	@DeleteMapping("/delete/{Id}")
	public String deleteTransaction(@PathVariable Long Id) {
		return transactionsService.deleteTransaction(Id);
	}
}
