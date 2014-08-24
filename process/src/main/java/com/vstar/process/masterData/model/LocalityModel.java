package com.vstar.process.masterData.model;

public class LocalityModel
{
  private String localityName;
  private long localityId;
  private String cityName;
  private boolean ticked;

  public String getLocalityName()
  {
    return localityName;
  }

  public void setLocalityName(String localityName)
  {
    this.localityName = localityName;
  }

  public long getLocalityId()
  {
    return localityId;
  }

  public void setLocalityId(long localityId)
  {
    this.localityId = localityId;
  }

  public String getCityName()
  {
    return cityName;
  }

  public void setCityName(String cityName)
  {
    this.cityName = cityName;
  }

  public boolean isTicked()
  {
    return ticked;
  }

  public void setTicked(boolean ticked)
  {
    this.ticked = ticked;
  }

}
