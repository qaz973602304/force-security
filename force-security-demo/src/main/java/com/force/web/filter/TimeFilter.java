package com.force.web.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//@Component 针对可以注入的Filter直接注入就可以使用
public class TimeFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("TimeFilter init");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("TimeFilter start ");
		long start = new Date().getTime();
		chain.doFilter(request, response);
		System.out.println("TimeFilter 耗时:" + (new Date().getTime() - start));
		System.out.println("TimeFilter end ");
	}

	@Override
	public void destroy() {
		System.out.println("TimeFilter destroy");

	}

}
