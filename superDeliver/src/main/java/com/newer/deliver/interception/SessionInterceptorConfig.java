package com.newer.deliver.interception;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SessionInterceptorConfig implements WebMvcConfigurer {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//注册拦截器
		registry.addInterceptor(createInterceptor())
		.addPathPatterns("/**")
		.excludePathPatterns("/ahead/login.html","/ahead/index.html","/ahead/register.html","/","/login","/register","/ahead/css/**","/ahead/js/**","/ahead/images/**","/img");
		
		//addPathPatterns("/**"):表所允许所有请求都进入拦截器
		//excludePathPatterns():用来配置排除的请求(不会进入拦截器)
	}
	
	@Bean
	public HandlerInterceptor createInterceptor() {
		return new AdminsInterCetor();
	}
}
