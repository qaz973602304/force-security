package com.force.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.force.service.HelloService;

public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {
	@Autowired
	private HelloService helloService;
	@Override
	public void initialize(MyConstraint constraintAnnotation) {
		System.out.println("MyConstraintValidator init");
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		helloService.greeting("tom");
		System.out.println(value);
		return false;
	}

}
