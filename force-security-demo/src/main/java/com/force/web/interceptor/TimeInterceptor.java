/**
 * 
 */
package com.force.web.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 所有控制层请求都会被拦截
 * @author ym
 *
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("TimeInterceptor preHandle");
		long start = new Date().getTime();
		request.setAttribute("start", start);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("TimeInterceptor postHandle");
		
		Long start = (Long) request.getAttribute("start");
		System.out.println(((HandlerMethod)handler).getBean().getClass().getName());
		System.out.println(((HandlerMethod)handler).getMethod().getName());
		
		System.out.println("TimeInterceptor 耗时:" + (new Date().getTime() - start));
		System.out.println("TimeInterceptor end ");
	}
	//无法捕获被@ControllerAdvice 拦截的异常
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("TimeInterceptor afterCompletion");
		
		Long start = (Long) request.getAttribute("start");
		
		System.out.println("TimeInterceptor 耗时:" + (new Date().getTime() - start));
		System.out.println("TimeInterceptor end ");
		System.out.println("TimeInterceptor Exception :" + ex);
	}
}
