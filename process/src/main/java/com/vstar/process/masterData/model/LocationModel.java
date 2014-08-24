package com.vstar.process.masterData.model;

import java.util.List;

public class LocationModel {
	private String stateName; 
	private String cityName;
	private long cityId;
	private List<LocalityModel> localities;
	
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public List<LocalityModel> getLocalities() {
		return localities;
	}
	public void setLocalities(List<LocalityModel> localities) {
		this.localities = localities;
	}
	public long getCityId() {
		return cityId;
	}
	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

}
