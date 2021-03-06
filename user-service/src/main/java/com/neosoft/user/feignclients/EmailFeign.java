package com.neosoft.user.feignclients;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neosoft.user.bean.User;

@FeignClient(name="EMAIL-SERVICE")
public interface EmailFeign {
	
	
	@RequestMapping("/mail/sent")
	public String sendEmail(User user);

}
