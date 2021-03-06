package com.neosoft.email.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.neosoft.email.bean.MailCounter;
import com.neosoft.email.bean.User;
import com.neosoft.email.repo.MailCounterRepo;

@Service
public class MailserviceImpl implements MailService {

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private MailCounterRepo counterRepo;

	
	//Sent an email
	@Override
	public boolean send(User user) throws MessagingException, IOException {

		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

		helper.setTo(user.getEmail());
		helper.setSubject("Activateion Mail");

		String templateBody = setTemplate(user);
		helper.setText(templateBody, true);

		mailSender.send(mimeMessage);
		MailCounter counter=new MailCounter();
		counterRepo.save(counter);
		return true;
	}

	
	
	//Set template body according to user
	@Override
	public String setTemplate(User user) throws IOException {

		String rawTeamplate = readTeamplate();

		// update RawTemplate
		rawTeamplate = rawTeamplate.replace("{NAME}", user.getFirsName());
		rawTeamplate = rawTeamplate.replace("{LASTNAME}", user.getLastName());
		rawTeamplate = rawTeamplate.replace("{EMAIL}", user.getEmail());

		return rawTeamplate;
	}

	
	
	//REad Template From Text File
	@Override
	public String readTeamplate() throws IOException {

//		StringBuilder sb = new StringBuilder("");
//		
//		try {
//			
//			FileReader fr = new FileReader("src/main/java/activeate-user-mail-template.txt");
//			BufferedReader br = new BufferedReader(fr);
//			String line = br.readLine();
/////email-service/src/main/java/activeate_user_mail_template.txt
//			while (line != null) {
//
//				sb.append(line);
//				line = br.readLine();
//			}br.close();
//		} finally {
//			
//		}
//
//		return sb.toString();
		
		return new String("Dear {NAME} {LASTNAME},:\r\n"
				+ "\r\n"
				+ "Please click on below link to activate your account.\r\n"
				+ "\r\n"
				+ "<a href='http://localhost:6060/user/setActivate?email={EMAIL}'>click here</a>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "Warm Welcome!!!\r\n"
				+ "\r\n"
				+ "Thanking you to joining us.\r\n"
				+ "");
	}
	
	public Long getTotalmailsend(){
		return counterRepo.count();
	}

}
