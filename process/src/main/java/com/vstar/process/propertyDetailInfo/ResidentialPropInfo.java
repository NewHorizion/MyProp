package com.vstar.process.propertyDetailInfo;

import java.util.Date;

/**
 * Residential Property Details
 */
public class ResidentialPropInfo
{
  private ResidentialUnits noOfBedRooms;
  private ResidentialUnits noOfBathRooms;
  private ResidentialUnits noOfBalonies;
  private ResidentialUnits furnishedStatus;
  private ResidentialUnits floorNumber;
  private ResidentialUnits totalFloor;
  private String possessionStatus;
  private String availableFrom;
  private String propertyDescription;
  private String landmarks;
  private boolean dealingType;
  private String termsNConditions;
  private String builderSociety;
  private ResidentialUnits[] inHouseAmenities;
  private ResidentialUnits[] externalAmenities;

  public ResidentialUnits getFurnishedStatus()
  {
    return furnishedStatus;
  }

  public void setFurnishedStatus(ResidentialUnits furnishedStatus)
  {
    this.furnishedStatus = furnishedStatus;
  }

  public String getPossessionStatus()
  {
    return possessionStatus;
  }

  public void setPossessionStatus(String possessionStatus)
  {
    this.possessionStatus = possessionStatus;
  }

  

  public String getAvailableFrom() {
	return availableFrom;
}

public void setAvailableFrom(String availableFrom) {
	this.availableFrom = availableFrom;
}

public ResidentialUnits getNoOfBedRooms()
  {
    return noOfBedRooms;
  }

  public void setNoOfBedRooms(ResidentialUnits noOfBedRooms)
  {
    this.noOfBedRooms = noOfBedRooms;
  }

  public ResidentialUnits getNoOfBathRooms()
  {
    return noOfBathRooms;
  }

  public void setNoOfBathRooms(ResidentialUnits noOfBathRooms)
  {
    this.noOfBathRooms = noOfBathRooms;
  }

  public ResidentialUnits getFloorNumber()
  {
    return floorNumber;
  }

  public void setFloorNumber(ResidentialUnits floorNumber)
  {
    this.floorNumber = floorNumber;
  }

  public ResidentialUnits getTotalFloor()
  {
    return totalFloor;
  }

  public void setTotalFloor(ResidentialUnits totalFloor)
  {
    this.totalFloor = totalFloor;
  }

  public ResidentialUnits getNoOfBalonies()
  {
    return noOfBalonies;
  }

  public void setNoOfBalonies(ResidentialUnits noOfBalonies)
  {
    this.noOfBalonies = noOfBalonies;
  }

  public String getPropertyDescription()
  {
    return propertyDescription;
  }

  public void setPropertyDescription(String propertyDescription)
  {
    this.propertyDescription = propertyDescription;
  }

  public boolean isDealingType()
  {
    return dealingType;
  }

  public void setDealingType(boolean dealingType)
  {
    this.dealingType = dealingType;
  }

  public String getLandmarks()
  {
    return landmarks;
  }

  public void setLandmarks(String landmarks)
  {
    this.landmarks = landmarks;
  }

  public String getTermsNConditions()
  {
    return termsNConditions;
  }

  public void setTermsNConditions(String termsNConditions)
  {
    this.termsNConditions = termsNConditions;
  }

  public ResidentialUnits[] getInHouseAmenities()
  {
    return inHouseAmenities;
  }

  public void setInHouseAmenities(ResidentialUnits[] inHouseAmenities)
  {
    this.inHouseAmenities = inHouseAmenities;
  }

  public ResidentialUnits[] getExternalAmenities()
  {
    return externalAmenities;
  }

  public void setExternalAmenities(ResidentialUnits[] externalAmenities)
  {
    this.externalAmenities = externalAmenities;
  }

/**
 * @return the builderSociety
 */
public String getBuilderSociety() {
	return builderSociety;
}

/**
 * @param builderSociety the builderSociety to set
 */
public void setBuilderSociety(String builderSociety) {
	this.builderSociety = builderSociety;
}
  
}
