package com.srx.financial.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srx.financial.app.entities.Role;
import com.srx.financial.app.repository.RoleRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RoleController {
	
	private RoleRepository roleRepository;

	public RoleController(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	@GetMapping("/roles")
	public List<Role> getRoles() {
		return (List<Role>) roleRepository.findAll();
	}

	@PostMapping("roles")
	void addRole(Role role) {
		roleRepository.save(role);
	}

}
