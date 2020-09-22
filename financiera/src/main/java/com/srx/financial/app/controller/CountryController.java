package com.srx.financial.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srx.financial.app.entities.Country;
import com.srx.financial.app.repository.CountryRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CountryController {
	
	private CountryRepository countryRepository;

	public CountryController(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}
	
	@GetMapping("/countrys")
	public List<Country> getCountrys() {
		return (List<Country>) countryRepository.findAll();
	}

	@PostMapping("countrys")
	void addCountry(Country country) {
		countryRepository.save(country);
	}

}
