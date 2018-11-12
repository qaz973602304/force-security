package com.force.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonView;
import com.force.validator.MyConstraint;

public class User {
	public interface UserSimpleView {
	};

	public interface UserDetailView extends UserSimpleView {
	};

	private String id;
	@MyConstraint(message = "智障")
	private String userName;
	@NotBlank(message = "密码不能为空")
	private String password;
	
	@Past(message = "时间必须是过去的时间")
	private Date birthday;

	@JsonView(UserSimpleView.class)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	@JsonView(UserDetailView.class)
	public void setPassword(String password) {
		this.password = password;
	}

	@JsonView(UserSimpleView.class)
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@JsonView(UserSimpleView.class)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
