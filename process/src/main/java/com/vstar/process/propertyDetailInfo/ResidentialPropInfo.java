package com.vstar.process.propertyDetailInfo;

import java.util.Date;

/**
 * Residential Property Details
 *
 */
public class ResidentialPropInfo
{
  private int noOfBedRooms;
  private int noOfBathRooms;
  private int noOfCalonies;
  private String furnishedStatus;
  private int floorNumber;
  private int totalFloor;
  private String possessionStatus;
  private Date availableFrom;

  public int getNoOfBedRooms()
  {
    return noOfBedRooms;
  }

  public void setNoOfBedRooms(int noOfBedRooms)
  {
    this.noOfBedRooms = noOfBedRooms;
  }

  public int getNoOfBathRooms()
  {
    return noOfBathRooms;
  }

  public void setNoOfBathRooms(int noOfBathRooms)
  {
    this.noOfBathRooms = noOfBathRooms;
  }

  public int getNoOfCalonies()
  {
    return noOfCalonies;
  }

  public void setNoOfCalonies(int noOfCalonies)
  {
    this.noOfCalonies = noOfCalonies;
  }

  public String getFurnishedStatus()
  {
    return furnishedStatus;
  }

  public void setFurnishedStatus(String furnishedStatus)
  {
    this.furnishedStatus = furnishedStatus;
  }

  public int getFloorNumber()
  {
    return floorNumber;
  }

  public void setFloorNumber(int floorNumber)
  {
    this.floorNumber = floorNumber;
  }

  public int getTotalFloor()
  {
    return totalFloor;
  }

  public void setTotalFloor(int totalFloor)
  {
    this.totalFloor = totalFloor;
  }

  public String getPossessionStatus()
  {
    return possessionStatus;
  }

  public void setPossessionStatus(String possessionStatus)
  {
    this.possessionStatus = possessionStatus;
  }

  public Date getAvailableFrom()
  {
    return availableFrom;
  }

  public void setAvailableFrom(Date availableFrom)
  {
    this.availableFrom = availableFrom;
  }
}
