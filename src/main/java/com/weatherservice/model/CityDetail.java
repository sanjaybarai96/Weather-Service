package com.weatherservice.model;

import java.io.Serializable;
import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CityDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonProperty("id")
	private BigInteger id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("state")
	private String state;
	@JsonProperty("country")
	private String country;
	@JsonProperty("coord")
	private Coord coord;
	
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Coord getCordinates() {
		return coord;
	}
	public void setCordinates(Coord coord) {
		this.coord = coord;
	}
	
	
}
