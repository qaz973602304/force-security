package com.force.web;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.force.dto.User;
import com.force.dto.UserQueryCondition;

@RestController
public class UserController {
	@RequestMapping(name = "/user", method = RequestMethod.GET)
	public List<User> query(UserQueryCondition userQueryCondition,
			@PageableDefault(page = 2, size = 17, sort = "userName,asc") Pageable pageable) {
		List<User> userlist = new ArrayList<User>();
		System.out.println(ReflectionToStringBuilder.toString(userQueryCondition, ToStringStyle.MULTI_LINE_STYLE));
		userlist.add(new User());
		userlist.add(new User());
		userlist.add(new User());
		return userlist;
	}

	@RequestMapping(value = "/user/{id://d+}", method = RequestMethod.GET)
	public User getInfo(@PathVariable String id) {
		User user = new User();
		user.setUserName("tom");
		return user;
	}
}