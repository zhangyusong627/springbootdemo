package com.example.springbootdemo.mapper;



import com.example.springbootdemo.model.TUser;

public interface TUserMapper {

	int deleteByPrimaryKey(Long id);

	int insert(TUser record);

	int insertSelective(TUser record);

	TUser selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(TUser record);

	int updateByPrimaryKey(TUser record);
}