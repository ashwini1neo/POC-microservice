package com.neosoft.user.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.neosoft.user.bean.User;
import com.neosoft.user.exception.UserCreationException;
import com.neosoft.user.exception.UserNotFoundException;
import com.neosoft.user.feignclients.EmailFeign;
import com.neosoft.user.service.UserService;
import com.neosoft.user.utill.DataMapper;
import com.neosoft.user.utill.OutBound;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
	
	@Autowired
	private OutBound outBond;
	
	
	
	//Add User
	@PostMapping(path = "/addUser", consumes = "application/json")
	public ResponseEntity<User> saveUser( @RequestBody User user) throws UserCreationException, JsonProcessingException {
		
		user.setIsActive(Boolean.FALSE);
		
//	Boolean mailSent = outBond.verificationMail(user);
		//if(mailSent) 
		User user2 = service.saveUser(user);
		
		return new ResponseEntity<>(user2, HttpStatus.CREATED);
	}
	
//	//Get All Active Users List
//	@GetMapping("/allActiveUsers")
//	public ResponseEntity<?> getAllActiveUsers() throws UserNotFoundException {
//		List<User> allUsers = service.getAllUsers();
//		return new ResponseEntity<List<User>>(allUsers,HttpStatus.OK);
//	}
//	
//	
//	//Get All Users List
//	@GetMapping("/allUsers")
//	public ResponseEntity<?> getAllUsers() throws UserNotFoundException {
//		List<User> allUsers = service.getAllUsers();
//		return new ResponseEntity<>(allUsers,HttpStatus.OK);
//	}
//	
//	
//	@GetMapping("/getById/{id}")
//	public ResponseEntity<? extends Object> getById(@PathVariable String id) throws UserNotFoundException, UserCreationException {
//		User userbyId = service.getById(id);
//		return new ResponseEntity<User>(userbyId , HttpStatus.OK);}
//	
//	
//	
//	//update user By id
//	@PutMapping("update/{id}")
//	public ResponseEntity<? extends Object> updateUser( @RequestBody User user,@PathVariable String id) throws UserNotFoundException, UserCreationException {
//		User userbyId = service.getById(id);
//		
//		Boolean b = user.getIsActive();
//
//		if (userbyId.getId() == user.getId() && Boolean.TRUE.equals(b)) {
//			User updatedUser = service.updateUser(user);
//			return new ResponseEntity<>(updatedUser , HttpStatus.OK);
//		}
//		else {
//			throw new UserNotFoundException("user not available with given id");
//		}
//		
//	}
//	
//
//	
//	@DeleteMapping("/hdelete/{id}")
//	public ResponseEntity<?> hardDelete(@PathVariable String id) throws UserNotFoundException{
//		service.deleteUser(id);
//		return new ResponseEntity<String>(new String("user deleted permanantly"),HttpStatus.OK);
//	}
//
	
	@PatchMapping("/setActivate/{email}")
	public ResponseEntity<? extends Object> setActivate(@PathVariable String email) throws UserNotFoundException, UserCreationException {
		User user1 = service.getByEmail(email);
		if(user1!=null) {
			//DataMapper
			user1.setIsActive(Boolean.TRUE);
			User updatedUser = service.updateUser(user1);
			return new ResponseEntity<>(updatedUser , HttpStatus.OK);
		}
		else {
			throw new UserNotFoundException("user not available with given id");
		}
		
//		
//	}
//	
//	
	}
}
