package com.spring.service;

import org.springframework.data.repository.CrudRepository;

import com.spring.model.PersonDetails;


public interface PersonRepository extends CrudRepository<PersonDetails, Integer>{
	
	

}
