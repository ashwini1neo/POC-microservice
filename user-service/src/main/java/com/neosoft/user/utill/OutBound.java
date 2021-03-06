package com.neosoft.user.utill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Template;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.neosoft.user.bean.User;
import com.neosoft.user.feignclients.EmailFeign;

@Component
public class OutBound {
	
	@Autowired
	private EmailFeign emailFeigen;

	public Boolean verificationMail(User user) throws JsonProcessingException {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// convert user in json

		String jsonUser = userToJson(user);

		HttpEntity<String> entity = new HttpEntity<>(jsonUser, headers);
		
	
		String response = emailFeigen.sendEmail(user);

//		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:6070/mail/sent", entity,
//				String.class);

		
		
		// ResponseEntity<String> response1 =
		// restTemplate.exchange("http://localhost:6070/mail/sent",
		// HttpMethod.POST,entity, String.class);
		
		
		
		if (response != null)
			return true;
		else
			return false;

	}

	public String userToJson(User user) throws JsonProcessingException {

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

		// ObjectMapper obMapper = new ObjectMapper();
		// String jsonUser =
		return ow.writeValueAsString(user);

	}

}
