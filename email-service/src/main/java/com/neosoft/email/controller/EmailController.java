package com.neosoft.email.controller;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.email.bean.User;
import com.neosoft.email.service.MailService;

@RestController
@RequestMapping("/mail")
public class EmailController {
	
	@Autowired
	public MailService service;
	
	@PostMapping("/sent")
	public String sendmail(@RequestBody User user) throws MessagingException, IOException {
		
		Boolean isSent=false;
		String message;
		if(Boolean.FALSE.equals(isSent) && user==null) {
			
		message="user is empty or mail aready sent";	
		return message;
			
		}else {
			
			service.send(user);
			return message="mail Sent Succesfully please  verfiy Account";
			
		}
		
	}
	
	
	
	@GetMapping("/mailCounter")
	public Long getMailCount(){
		return service.getTotalmailsend();
	
	}
}
