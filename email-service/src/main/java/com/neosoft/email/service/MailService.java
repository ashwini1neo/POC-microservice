package com.neosoft.email.service;
import java.io.IOException;

import javax.mail.MessagingException;

import com.neosoft.email.bean.User;

public interface MailService {
	 
	public boolean send(User user) throws MessagingException, IOException;
	
	public String setTemplate(User user) throws IOException;
	
	public String readTeamplate() throws  IOException;
	
	public Long getTotalmailsend();
}
