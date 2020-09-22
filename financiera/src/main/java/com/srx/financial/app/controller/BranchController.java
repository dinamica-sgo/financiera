package com.srx.financial.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srx.financial.app.entities.Branch;
import com.srx.financial.app.repository.BranchRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BranchController {

	private BranchRepository branchRepository;

	public BranchController(BranchRepository branchRepository) {
		this.branchRepository = branchRepository;
	}
	
	@GetMapping("/branches")
	public List<Branch> getBranchs() {
		return (List<Branch>) branchRepository.findAll();
	}

	@PostMapping("branches")
	void addBranch(Branch branch) {
		branchRepository.save(branch);
	}
}
