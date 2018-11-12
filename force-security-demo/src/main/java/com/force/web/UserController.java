package com.force.web;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.force.dto.User;
import com.force.dto.UserQueryCondition;

@RestController
@RequestMapping("/user")
public class UserController {
	@JsonView(User.UserSimpleView.class)
	@GetMapping
	public List<User> query(UserQueryCondition userQueryCondition,
			@PageableDefault(page = 2, size = 17, sort = "userName,asc") Pageable pageable) {
		List<User> userlist = new ArrayList<User>();
		System.out.println(ReflectionToStringBuilder.toString(userQueryCondition, ToStringStyle.MULTI_LINE_STYLE));
		userlist.add(new User());
		userlist.add(new User());
		userlist.add(new User());
		return userlist;
	}
	@JsonView(User.UserDetailView.class)
	@GetMapping("/{id:\\d+}")
	public User getInfo(@PathVariable String id) {
		User user = new User();
		user.setUserName("tom");
		return user;
	}
}