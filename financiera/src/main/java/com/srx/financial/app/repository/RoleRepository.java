package com.srx.financial.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.srx.financial.app.entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

}
