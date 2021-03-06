package com.force.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.force.exception.UserNotExistException;
/**
 * 拦截其他Controller 异常
 * @author ym
 *
 */
@ControllerAdvice
public class ControllerExceptionHandler {
	@ExceptionHandler(UserNotExistException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String,Object> handlerUserNotExistException(UserNotExistException ex){
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("id", ex.getId());
		result.put("mess", ex.getMessage());
		return result;
	}
}
