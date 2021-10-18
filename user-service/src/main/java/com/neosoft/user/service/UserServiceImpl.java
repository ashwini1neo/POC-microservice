package com.neosoft.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neosoft.user.bean.User;
import com.neosoft.user.entity.UserEntity;
import com.neosoft.user.exception.UserCreationException;
import com.neosoft.user.exception.UserNotFoundException;
import com.neosoft.user.repository.UserRepository;
import com.neosoft.user.utill.DataMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;

	@Override
	@Transactional
	public User saveUser(User user) throws UserCreationException {

		try {
			UserEntity entity = DataMapper.beanToEntity(user);
			UserEntity entity2 = repo.save(entity);
			User user1 = DataMapper.entityToBean(entity2);
			return user1;
		} catch (Exception e) {
			throw new UserCreationException();
		}
	}

	@Override
	@Transactional
	public User updateUser(User user) throws UserCreationException {
		try {
			UserEntity entity = DataMapper.beanToEntity(user);
			UserEntity entity2 = repo.save(entity);
			User user1 = DataMapper.entityToBean(entity2);
			return user1;
		} catch (Exception e) {
			throw new UserCreationException();
		}
	}

//	@Override
//	public User getById(String id) throws UserNotFoundException {
//		User user = new User();
//		try {
//			if (!(id.isEmpty())) {
//				Optional<UserEntity> findById = repo.findById(id);
//				// UserEntity findById = repo.getOne(id);
//				if (findById.isPresent()) {
//					UserEntity userEntity = findById.get();
//					user = DataMapper.entityToBean(userEntity);
//					return user;
//				}
//			}
//		} catch (Exception e) {
//			throw new UserNotFoundException("User not availabel with id " + id);
//		}
//		return user;
//	}
//
//	@Override
//	public List<User> getAllUsers() throws UserNotFoundException {
//		ArrayList<User> allUsers = new ArrayList();
//		try {
//			List<UserEntity> allUsers1 = repo.findAll();
//			if (allUsers1 != null) {
//				for (UserEntity userEntity : allUsers1) {
//					User user = DataMapper.entityToBean(userEntity);
//					allUsers.add(user);
//
//				}
//				return allUsers;
//			}
//		} catch (Exception e) {
//			throw new UserNotFoundException("Users not Availabel");
//		}
//		 return allUsers;
//
//	}
//
//	@Override
//	public void deleteUser(String id) throws UserNotFoundException {
//		try {
//			if (!(id.isEmpty()))
//				repo.deleteById(id);
//			
//		} catch (Exception e) {
//			throw new UserNotFoundException("User not availabel with id " + id);
//		}
//
//	}
//
	@Override
	public User getByEmail(String email) {
		  List<UserEntity> findByEmail = repo.findByEmail(email);
		UserEntity userEntity = findByEmail.get(0);
		User user = DataMapper.entityToBean(userEntity);
		return user;
	}

}
