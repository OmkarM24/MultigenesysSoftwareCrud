package com.example.MultigenesysSoftwareCrud.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MultigenesysSoftwareCrud.Dao.TransactionsDao;
import com.example.MultigenesysSoftwareCrud.Entity.Transactions;

@Service
public class TransactionsService {
	
	@Autowired
	TransactionsDao transactionsDao;
	
	public String saveTransaction(Transactions transactions) {
		if(transactions.getEmail().contains("@")) {
		return transactionsDao.saveTransactions(transactions);
	}
		return "Enter proper email with @";
		
	}
	
	public List<Transactions> getAlltransaction() {
		return transactionsDao.getAllTrsansactions();
	}
	
	public String updateTransaction(Transactions transactions,Long Id) {
		return transactionsDao.updateTransactions(transactions, Id);
	}
	
	public String deleteTransaction(Long Id) {
		return transactionsDao.deleteTransactions(Id);
	}

}
