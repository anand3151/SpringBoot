package com.spring.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.PersonDetails;

import com.spring.service.PersonRepository;

@Service
public class PersonDetailsDao {

	@Autowired
	PersonRepository personRepository;
	
	public PersonDetails create(PersonDetails personDetails) {
		personRepository.save(personDetails);
		return personDetails;
	}

	public Optional<PersonDetails> get(int id) {
		
		return personRepository.findById(id);
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		personRepository.deleteById(id);
	}

}
