package com.weatherservice;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherservice.model.CityDetail;
import com.weatherservice.model.CityList;
import com.weatherservice.model.WeatherUrl;

@SpringBootApplication
public class WeatherServiceApplication{

	@Value("${weather.urls}")
	private String url;
	
	@Value("${weather.apikey}")
	private String apiKey;
	
	@Bean
	public WeatherUrl weatherUrl() {
		
		WeatherUrl weatherUrl = new WeatherUrl();
		weatherUrl.setUrl(url);
		weatherUrl.setApiKey(apiKey);
		return weatherUrl;
	}
	
	//Reading city detail from json file
	@Bean
	public CityList citList() {
		CityList cityList = new CityList();
		ObjectMapper objectMapper = new ObjectMapper();
		TypeReference<List<CityDetail>> typeReference = new TypeReference<List<CityDetail>>(){};
		//read json file and convert to customer object
		List<CityDetail> cityDetail = new ArrayList<>();
		try {
			cityDetail = objectMapper.readValue(new File(".//src//main//resources//city.json"), typeReference);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cityList.setCityLists(cityDetail);
		return cityList;
	}
	
	@Bean
	public WebClient.Builder getWebClientBuilder(){
		return WebClient.builder();
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(WeatherServiceApplication.class, args);
	}
}
