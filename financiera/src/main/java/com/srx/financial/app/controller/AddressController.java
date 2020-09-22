package com.srx.financial.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srx.financial.app.entities.Address;
import com.srx.financial.app.repository.AddressRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AddressController {

	private AddressRepository addressRepository;

	public AddressController(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}
	
	@GetMapping("/addresss")
	public List<Address> getAddresss() {
		return (List<Address>) addressRepository.findAll();
	}

	@PostMapping("addresss")
	void addAddress(Address address) {
		addressRepository.save(address);
	}
	
}
