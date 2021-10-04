package com.weatherservice.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import com.weatherservice.model.CityList;
import com.weatherservice.model.WeatherInfo;
import com.weatherservice.model.Coord;
import com.weatherservice.model.WeatherResponse;
import com.weatherservice.model.WeatherUrl;
import com.weatherservice.util.WeatherServiceUtil;


@RestController
public class WeatherController {
	
	@Autowired
	private WeatherUrl weatherData;
	
	@Autowired
	WebClient.Builder webClientBuilder;
	
	@Autowired
	CityList cityList;
	
	@RequestMapping(value = "/weather",method=RequestMethod.GET)
	@ResponseBody
	public String getWeather(@RequestParam String cityName) {
		Coord coordinates = WeatherServiceUtil.getCoord(cityList.getCityLists(), cityName);
		WeatherResponse weatherResponse = webClientBuilder.build()
														.get()
														.uri(String.format(weatherData.getUrl(),coordinates.getLat(),coordinates.getLon(),weatherData.getApiKey()))
														.retrieve()
														.bodyToMono(WeatherResponse.class)
														.block();
		
		List<WeatherInfo> singleWeatherInfo = weatherResponse.getWeatherInfo().stream()
																			  .filter(weather->LocalDate.now().isEqual(WeatherServiceUtil.convertLongToDate(weather.getDateTime())))
																			  .map(weather->weather.setDate(WeatherServiceUtil.convertLongToDate(weather.getDateTime()).toString()))
																			  .collect(Collectors.toList());
		weatherResponse.setWeatherInfo(singleWeatherInfo);
		return WeatherServiceUtil.JsonSuccessResponse(new JSONObject(weatherResponse));
	}
	
	@RequestMapping(value = "/weather/forecast",method=RequestMethod.GET)
	public String getForecast(@RequestParam String cityName) {
		Coord coordinates = WeatherServiceUtil.getCoord(cityList.getCityLists(), cityName);
		WeatherResponse weatherResponse = webClientBuilder.build()
														.get()
														.uri(String.format(String.format(weatherData.getUrl(),coordinates.getLat(),coordinates.getLon(),weatherData.getApiKey())))
														.retrieve()
														.bodyToMono(WeatherResponse.class)
														.block();
		
		List<WeatherInfo> singleWeatherInfo = weatherResponse.getWeatherInfo().stream()
															 .filter(weather->LocalDate.now().plusDays(3).isAfter(WeatherServiceUtil.convertLongToDate(weather.getDateTime())))
															 .map(weather->weather.setDate(WeatherServiceUtil.convertLongToDate(weather.getDateTime()).toString()))
															 .collect(Collectors.toList());
		weatherResponse.setWeatherInfo(singleWeatherInfo);
		return WeatherServiceUtil.JsonSuccessResponse(new JSONObject(weatherResponse));
	}
	
	
}
