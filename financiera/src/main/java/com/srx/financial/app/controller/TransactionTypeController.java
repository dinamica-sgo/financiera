package com.srx.financial.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srx.financial.app.entities.TransactionType;
import com.srx.financial.app.repository.TransactionTypeRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TransactionTypeController {
	

	private final TransactionTypeRepository transactionTypeRepository;

	public TransactionTypeController(TransactionTypeRepository transactionTypeRepository) {
		this.transactionTypeRepository = transactionTypeRepository;
	}
	
	 @GetMapping("/transactionTypes")
	    public List<TransactionType> getTransactionTypes() {
		return (List<TransactionType>) transactionTypeRepository.findAll();
	}
	 
	@PostMapping("/transactioTypes")
	void addUser(@RequestBody TransactionType transactionType) {
        transactionTypeRepository.save(transactionType);
    }
}
