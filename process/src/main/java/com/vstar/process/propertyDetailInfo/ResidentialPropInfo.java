package com.vstar.process.propertyDetailInfo;

import java.util.Date;

/**
 * Residential Property Details
 * 
 */
public class ResidentialPropInfo {
	private ResidentialUnits noOfBedRooms;
	private ResidentialUnits noOfBathRooms;
	private ResidentialUnits noOfCalonies;
	private String furnishedStatus;
	private ResidentialUnits floorNumber;
	private ResidentialUnits totalFloor;
	private String possessionStatus;
	private Date availableFrom;


	public String getFurnishedStatus() {
		return furnishedStatus;
	}

	public void setFurnishedStatus(String furnishedStatus) {
		this.furnishedStatus = furnishedStatus;
	}

	public String getPossessionStatus() {
		return possessionStatus;
	}

	public void setPossessionStatus(String possessionStatus) {
		this.possessionStatus = possessionStatus;
	}

	public Date getAvailableFrom() {
		return availableFrom;
	}

	public void setAvailableFrom(Date availableFrom) {
		this.availableFrom = availableFrom;
	}

	public ResidentialUnits getNoOfCalonies() {
		return noOfCalonies;
	}

	public void setNoOfCalonies(ResidentialUnits noOfCalonies) {
		this.noOfCalonies = noOfCalonies;
	}

	public ResidentialUnits getNoOfBedRooms() {
		return noOfBedRooms;
	}

	public void setNoOfBedRooms(ResidentialUnits noOfBedRooms) {
		this.noOfBedRooms = noOfBedRooms;
	}

	public ResidentialUnits getNoOfBathRooms() {
		return noOfBathRooms;
	}

	public void setNoOfBathRooms(ResidentialUnits noOfBathRooms) {
		this.noOfBathRooms = noOfBathRooms;
	}

	public ResidentialUnits getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(ResidentialUnits floorNumber) {
		this.floorNumber = floorNumber;
	}

	public ResidentialUnits getTotalFloor() {
		return totalFloor;
	}

	public void setTotalFloor(ResidentialUnits totalFloor) {
		this.totalFloor = totalFloor;
	}
}
