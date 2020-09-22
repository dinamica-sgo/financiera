package com.srx.financial.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srx.financial.app.entities.UserRole;
import com.srx.financial.app.repository.UserRoleRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserRoleController {
	

	private final UserRoleRepository userRoleRepository;
	
	
    public UserRoleController(UserRoleRepository userRoleRepository) {
		super();
		this.userRoleRepository = userRoleRepository;
	}

	@GetMapping("/userRoles")
    public List<UserRole> getUserRoles() {
        return (List<UserRole>) userRoleRepository.findAll();
    }
 
    @PostMapping("/userRoles")
    void addUserRole(@RequestBody UserRole userRole) {
        userRoleRepository.save(userRole);
    }

}
