package com.neosoft.user.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.neosoft.user.entity.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity, String>{
	
	@Query("{ 'email' : ?0 }")
	public List<UserEntity> findByEmail(String email);

}
