package com.neosoft.email.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.neosoft.email.bean.MailCounter;

public interface MailCounterRepo extends JpaRepository<MailCounter, Integer> {
	
	
	
//	public Boolean updateCount();
	
	//public Integer find

}
