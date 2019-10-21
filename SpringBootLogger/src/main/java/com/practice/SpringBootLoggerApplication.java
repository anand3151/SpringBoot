package com.practice;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootLoggerApplication {

	@Autowired
	Message msg;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootLoggerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootLoggerApplication.class, args);
	}

	@GetMapping("/welcome")	
	public Message getMsg()
	{
		msg.setId("1");
		//msg.setMessage("Welcome");
		LOGGER.info(msg.toString());
		return msg;
	}
}
