package com.neosoft.user.entity;

import java.io.Serializable;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document
//(collection = "user_collection")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	private String id;
	
	private String firsName;
	
	
	private String lastName;
	
	//@UniqueElements
	private String email;
	
	private Boolean isActive;


}
