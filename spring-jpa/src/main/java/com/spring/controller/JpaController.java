package com.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dao.PersonDetailsDao;
import com.spring.model.PersonDetails;

@RestController
public class JpaController {

	@Autowired
	PersonDetailsDao personDetailsDao;
	
	@PostMapping("/createId")
	public PersonDetails createId(@RequestBody PersonDetails person) {
		return personDetailsDao.create(person);
	}
	
	@GetMapping("/getById/{id}")
	public Optional<PersonDetails> getById(@PathVariable int id)
	{
		return personDetailsDao.get(id);
	}
	
	@PutMapping("/deleteById/{id}")
	public String deleteById(@PathVariable int id)
	{
		personDetailsDao.deleteById(id);
		return "Deleted";
	}
}
