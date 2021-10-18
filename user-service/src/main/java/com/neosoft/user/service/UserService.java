package com.neosoft.user.service;

import java.util.List;

import com.neosoft.user.bean.User;
import com.neosoft.user.entity.UserEntity;
import com.neosoft.user.exception.UserCreationException;
import com.neosoft.user.exception.UserNotFoundException;

public interface UserService {
	
	public User saveUser(User user) throws UserCreationException;
	
	public User updateUser(User user) throws UserCreationException;
//	
//	public User getById(String id) throws UserNotFoundException;
//	
//	
//	public List<User> getAllUsers() throws UserNotFoundException;
//	
//	public void deleteUser(String id) throws UserNotFoundException;
//
	public User getByEmail(String email);
	

}
