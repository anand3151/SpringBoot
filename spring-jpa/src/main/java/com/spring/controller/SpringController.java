/**
 * 
 */
package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Message;

import com.spring.service.PersonRepository;

/**
 * @author Anand
 *
 */
@RestController
public class SpringController {
	
	@Autowired
	PersonRepository personRepository;

	@GetMapping("/getMsg")
	public String getMsg()
	{
		return "hello world";
	}
	
	@PostMapping("/sendMsg")
	public String sendMsg(@RequestParam("sendMsg") String sendMsg)
	{
		return "Message Send";
		
	}
	
	@PostMapping("/msgdetails")
	public Message details(@RequestBody Message msg)
	{
		return msg;
	}
	
	
}
