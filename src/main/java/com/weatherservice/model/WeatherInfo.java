package com.weatherservice.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherInfo {

	@JsonProperty("dt")
	private long dateTime;
	private double maxTemp;
	private double minTemp;
	private String description;
	@JsonIgnoreProperties
	private String date;
	
	public long getDateTime() {
		return dateTime;
	}
	public void setDateTime(long dateTime) {
		this.dateTime = dateTime;
	}
	public double getMaxTemp() {
		return maxTemp;
	}
	public void setMaxTemp(double maxTemp) {
		this.maxTemp = maxTemp;
	}
	public double getMinTemp() {
		return minTemp;
	}
	public void setMinTemp(double minTemp) {
		this.minTemp = minTemp;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@JsonProperty("temp")
	public void setTemp(Map<String, Object> temp) {
		setMaxTemp(Double.valueOf(temp.get("max").toString()));
		setMinTemp(Double.valueOf(temp.get("min").toString()));
	}
	
	public String getDate() {
		return date;
	}
	public WeatherInfo setDate(String date) {
		this.date = date;
		return this;
	}
	@JsonProperty("weather")
	public void setWeather(List<Map<String, Object>> weatherEntries) {
		Map<String, Object> weather = weatherEntries.get(0);
		setDescription((String) weather.get("description"));
	}
	
}
