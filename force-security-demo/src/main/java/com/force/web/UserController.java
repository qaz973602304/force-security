package com.force.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.force.dto.User;
import com.force.dto.UserQueryCondition;
import com.force.exception.UserNotExistException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/user")
public class UserController {
	@ApiOperation("创建用户服务")
	@PostMapping
	public User create(@Valid @RequestBody User user, BindingResult errors) {
		if (errors.hasErrors()) {
			errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
		}
		System.out.println(user.getId());
		System.out.println(user.getUserName());
		System.out.println(user.getPassword());
		System.out.println(user.getBirthday());

		user.setId("1");
		return user;
	}

	@ApiOperation("修改用户服务")
	@PutMapping("/{id:\\d+}")
	public User update(@Valid @RequestBody User user, BindingResult errors) {
		if (errors.hasErrors()) {
			errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
		}
		System.out.println(user.getId());
		System.out.println(user.getUserName());
		System.out.println(user.getPassword());
		System.out.println(user.getBirthday());

		user.setId("1");
		return user;
	}

	@ApiOperation("查询用户服务")
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

//	@ApiOperation("根据ID查询用户服务")
//	@JsonView(User.UserDetailView.class)
//	@GetMapping("/{id:\\d+}")
//	public User getInfo(@PathVariable String id) {
//		User user = new User();
//		user.setUserName("tom");
//		return user;
//	}

	@ApiOperation("删除用户服务")
	@DeleteMapping("/{id:\\d+}")
	public void delete(@ApiParam(value = "删除ID") @PathVariable String id) {
		System.out.println(id);
	}
//	测试自定义异常
	@JsonView(User.UserDetailView.class)
	@GetMapping("/{id:\\d+}")
	public User getInfo(@PathVariable String id) {
		throw new UserNotExistException("sdfs");
//		User user = new User();
//		user.setUserName("tom");
//		return user;
	}
}