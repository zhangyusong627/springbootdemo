package com.example.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootdemo.dao.UserDao;
import com.example.springbootdemo.model.TUser;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public TUser getUser(long id){
		return userDao.selectByPrimaryKey(id);
	}
	
	public int deleteUser(long id){
		return userDao.deleteByPrimaryKey(id);
	}
	
	public int insertUser(TUser user){
		
		return userDao.insert(new TUser(2L,"老板","11111111"));
	}

}
