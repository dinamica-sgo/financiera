package com.srx.financial.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srx.financial.app.entities.Fee;
import com.srx.financial.app.repository.FeeRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FeeController {

	private FeeRepository feeRepository;

	public FeeController(FeeRepository feeRepository) {
		this.feeRepository = feeRepository;
	}
	
	@GetMapping("/fees")
	public List<Fee> getFees() {
		return (List<Fee>) feeRepository.findAll();
	}

	@PostMapping("fees")
	void addFee(Fee fee) {
		feeRepository.save(fee);
	}
	
}
