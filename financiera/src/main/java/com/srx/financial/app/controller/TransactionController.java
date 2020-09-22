package com.srx.financial.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srx.financial.app.entities.Transaction;
import com.srx.financial.app.repository.TransactionRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TransactionController {
	
	private TransactionRepository transactionRepository;

	public TransactionController(TransactionRepository transactionRepository) {
		super();
		this.transactionRepository = transactionRepository;
	}
	
	@GetMapping("/transactions")
	public List<Transaction> getTransactions() {
		return (List<Transaction>) transactionRepository.findAll();
	}

	@PostMapping("transactions")
	void addTransaction(Transaction transaction) {
		transactionRepository.save(transaction);
	}
}
