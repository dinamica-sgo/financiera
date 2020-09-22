package com.srx.financial.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.srx.financial.app.entities.Fee;

@Repository
public interface FeeRepository extends CrudRepository<Fee, Integer> {

}
