package com.force.web.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.force.web.filter.TimeFilter;
import com.force.web.interceptor.TimeInterceptor;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
	@Autowired
	private TimeInterceptor timeInterceptor;

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(timeInterceptor);
	}

//	@Bean
	public FilterRegistrationBean<TimeFilter> timeFilter() {
		FilterRegistrationBean<TimeFilter> registrationBean = new FilterRegistrationBean<TimeFilter>();
		TimeFilter timeFilter = new TimeFilter();
		registrationBean.setFilter(timeFilter);
		List<String> urls = new ArrayList<String>();
		// 设置 过滤器过滤的url
		urls.add("/*");
		registrationBean.setUrlPatterns(urls);

		return registrationBean;
	}

	/**
	 * 发现如果继承了WebMvcConfigurationSupport，则在yml中配置的相关内容会失效。 需要重新指定静态资源
	 * 
	 * @param registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		super.addResourceHandlers(registry);
	}
}
