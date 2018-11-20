package com.force.dto;

import io.swagger.annotations.ApiModelProperty;

public class UserQueryCondition {
	@ApiModelProperty(value="用户名")
	private String userName;
	@ApiModelProperty(value="年龄起始")
	private int age;
	@ApiModelProperty(value="年龄结束")
	private int ageTo;
	private String xxx;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAgeTo() {
		return ageTo;
	}

	public void setAgeTo(int ageTo) {
		this.ageTo = ageTo;
	}

	public String getXxx() {
		return xxx;
	}

	public void setXxx(String xxx) {
		this.xxx = xxx;
	}

}
