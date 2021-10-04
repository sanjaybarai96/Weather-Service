package com.weatherservice.model;

import java.util.List;

public class CityList {

	public List<CityDetail> cityLists;
	
	public CityList(){
		super();
	}

	public List<CityDetail> getCityLists() {
		return cityLists;
	}

	public void setCityLists(List<CityDetail> cityLists) {
		this.cityLists = cityLists;
	};
	
}
