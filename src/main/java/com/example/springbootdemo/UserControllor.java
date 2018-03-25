package com.example.springbootdemo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*@Api("USER相关的api")
@RestController
@RequestMapping("/user")*/
public class UserControllor {
	
	@ApiOperation("根据ID获取用户信息")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType="query",name="id",dataType="int",required=true,value="用户的id",defaultValue="1")})
	@ApiResponses({
		@ApiResponse(code=400,message="请求参数没有填好"),
		@ApiResponse(code=404,message="请求路径错误")
	})
	@RequestMapping(value="/getUserInfo",method=RequestMethod.GET)
	public User getUserInfo(@RequestParam("id") int id){
		if (id==1) {
			return new User(1, "小红", "123456");
		}
		return new User(2, "小刚", "123456");
	}
	
	
	
	

}
