package com.neosoft.user.utill;

import org.springframework.beans.BeanUtils;

import com.neosoft.user.bean.User;
import com.neosoft.user.entity.UserEntity;

public class DataMapper {
	
	public static UserEntity beanToEntity(User user){
		UserEntity entity=new UserEntity();
		BeanUtils.copyProperties(user, entity);
		return entity;
	}

	
	public static User entityToBean(UserEntity entity){
		User user=new User();
		BeanUtils.copyProperties(entity,user);
		return user;
	}
}
