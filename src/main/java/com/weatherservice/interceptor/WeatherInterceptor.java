package com.weatherservice.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class WeatherInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String method = request.getMethod();
		if(method.equalsIgnoreCase("GET")) {
			System.out.println("done");
		}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
