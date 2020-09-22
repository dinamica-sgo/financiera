package com.srx.financial.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srx.financial.app.entities.City;
import com.srx.financial.app.repository.CityRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CityController {

	private CityRepository cityRepository;

	public CityController(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}
	
	@GetMapping("/cities")
	public List<City> getCitys() {
		return (List<City>) cityRepository.findAll();
	}

	@PostMapping("cities")
	void addCity(City city) {
		cityRepository.save(city);
	}
}
