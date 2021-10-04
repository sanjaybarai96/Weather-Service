package com.weatherservice.model;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse implements Serializable {
	private static final long serialVersionUID = 7406210628182440902L;
	
	@JsonProperty("lon")
	private double lon;
	@JsonProperty("lat")
	private double lat;
	@JsonProperty("daily")
	private List<WeatherInfo> weatherInfo;
	
	public WeatherResponse() {
		super();
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public List<WeatherInfo> getWeatherInfo() {
		return weatherInfo;
	}

	public void setWeatherInfo(List<WeatherInfo> weatherInfo) {
		this.weatherInfo = weatherInfo;
	}
	
}
