package com.example.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootdemo.model.TUser;
import com.example.springbootdemo.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("Tuser相关api")
@RestController
@RequestMapping("/tuser")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ApiOperation("根据数据库ID获取用户信息")
	
	@ApiImplicitParams({
		@ApiImplicitParam(paramType="query",name="id",dataType="long",required=true,value="用户的id",defaultValue="1")})
	@ApiResponses({
		@ApiResponse(code=401,message="权限校验不通过"),
		
	})
	@RequestMapping(value = "/getUserInfo" , method=RequestMethod.GET)
	public TUser getUserInfo(@RequestParam("id") long id){
		return userService.getUser(id);
	}
	
	
    @ApiOperation("根据数据库ID删除用户信息")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType="query",name="id",dataType="long",required=true,value="用户的id",defaultValue="1")})
	@ApiResponses({
		@ApiResponse(code=401,message="权限校验不通过"),
	})
	@RequestMapping(value = "/deleteUserByID" , method=RequestMethod.GET)
	public int deleteUserByID(@RequestParam("id") long id){
		return userService.deleteUser(id);
	}
    
    @ApiOperation("向数据库增加用户信息")
    @RequestMapping(value = "/insertUser" , method=RequestMethod.GET )
    public int insertUser(TUser user){
    	return	userService.insertUser(user);
    }

}
