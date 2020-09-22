package com.srx.financial.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srx.financial.app.entities.Company;
import com.srx.financial.app.repository.CompanyRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CompanyController {
	
	private CompanyRepository companyRepository;

	public CompanyController(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}
	
	@GetMapping("/companies")
	public List<Company> getCompanys() {
		return (List<Company>) companyRepository.findAll();
	}

	@GetMapping("/company/{id}")
	public Optional<Company> getCompan(@PathVariable("id") int id) {
		return  companyRepository.findById(id);
	}
	
	@PostMapping("companies")
	void addCompany(Company company) {
		companyRepository.save(company);
	}

}
