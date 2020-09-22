package com.srx.financial.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.srx.financial.app.entities.City;

@Repository
public interface CityRepository extends CrudRepository<City, Integer> {

}
