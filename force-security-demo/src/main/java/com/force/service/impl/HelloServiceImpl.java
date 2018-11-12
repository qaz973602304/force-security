package com.force.service.impl;

import org.springframework.stereotype.Service;

import com.force.service.HelloService;
@Service
public class HelloServiceImpl implements HelloService{

	@Override
	public String greeting(String name) {
		System.out.println(name);
		return "hello "+name;
	}

}
