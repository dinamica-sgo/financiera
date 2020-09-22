package com.srx.financial.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srx.financial.app.entities.Province;
import com.srx.financial.app.repository.ProvinceRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProvinceController {
	
	private ProvinceRepository provinceRepository;

	public ProvinceController(ProvinceRepository provinceRepository) {
		this.provinceRepository = provinceRepository;
	}
	
	@GetMapping("/provinces")
	public List<Province> getProvinces() {
		return (List<Province>) provinceRepository.findAll();
	}

	@PostMapping("provinces")
	void addProvince(Province province) {
		provinceRepository.save(province);
	}

}
