package com.example.springbootdemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springbootdemo.mapper.TUserMapper;
import com.example.springbootdemo.model.TUser;

@Repository
public class UserDao {
	
	@Autowired
	private TUserMapper userMapper;
	
	public TUser selectByPrimaryKey(long id){
		return userMapper.selectByPrimaryKey(id);
	}
	
	public int deleteByPrimaryKey(long id){
		return userMapper.deleteByPrimaryKey(id);
	}
	
	public int insert(TUser user){
		return userMapper.insert(user);
	}

}
