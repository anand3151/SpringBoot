package com.email;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application  {

   @Autowired
   SendEmail sendEmail;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
       
    }
    @GetMapping("/")
    public String home() throws Exception
    {
    	//sendEmail.sendEmail();
    	sendEmail.sendEmailWithAttachment();
    	//sendEmail.sendAttachment();
    	return "home";
    }
	
    }
