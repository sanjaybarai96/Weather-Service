package com.weatherservice.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.weatherservice.util.WeatherServiceUtil;

@ControllerAdvice
public class WeatherCustomExceptionHandler {

	@ExceptionHandler(value=WeatherNotFoundException.class)
	public ResponseEntity<String> weatherNotFoundException(WeatherNotFoundException exception){
		HttpStatus status = HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(WeatherServiceUtil.createErrorJson(exception, status),status);
	}
}
