package com.neosoft.email.bean;

import java.io.Serializable;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String firsName;

	private String lastName;

	private String email;
	
	private Boolean isActive;

}
