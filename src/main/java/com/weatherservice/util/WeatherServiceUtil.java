package com.weatherservice.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;

import com.weatherservice.exceptionhandler.WeatherNotFoundException;
import com.weatherservice.model.CityDetail;
import com.weatherservice.model.Coord;

public class WeatherServiceUtil {

	public static Coord getCoord(List<CityDetail> cityList,String cityName) {
		Optional<CityDetail> optional = getSingleCityObj(cityList,cityName);
		if(!optional.isPresent()) {
			throw new WeatherNotFoundException("Weather info not found of given city name");
		}
		return optional.get().getCordinates();
	}
	
	private static Optional<CityDetail> getSingleCityObj(List<CityDetail> cityList,String cityName) {
		return cityList.stream()
				.filter(cities->cities.getName().toLowerCase().equals(cityName.toLowerCase()))
				.findFirst();
	}
	
	public static LocalDate convertLongToDate(long timestamp) {
		return Instant.ofEpochMilli(timestamp * 1000).atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	public static String JsonSuccessResponse(JSONObject msg) {
		return new JSONObject().put("status",true)
						.put("data", msg).toString();
	}
	
	public static String JsonFailureResponse(JSONObject msg) {
		return new JSONObject().put("status",false)
							   .put("data", msg).toString();
	}
	
	public static String createErrorJson(Exception ex,HttpStatus status) {
		JSONObject errorJson = new JSONObject();
		errorJson.put("status", status.value())
				 .put("error", status.getReasonPhrase())
				 .put("message", ex.getMessage());
		return errorJson.toString();
	}

}
