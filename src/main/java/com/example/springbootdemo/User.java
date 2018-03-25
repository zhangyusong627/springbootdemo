package com.example.springbootdemo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户模型")
@AllArgsConstructor
@Getter
public class User {
	@ApiModelProperty("用户ID")
	private int id;
	
	@ApiModelProperty("用户姓名")
	private String name;
	
	@ApiModelProperty("用户密码")
	private String password;

}
