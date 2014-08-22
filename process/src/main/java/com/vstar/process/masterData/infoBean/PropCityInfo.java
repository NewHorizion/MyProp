package com.vstar.process.masterData.infoBean;

/**
 * Info bean for passing City Data
 *
 */
public class PropCityInfo
{
  private long cityId;
  private String cityName;

  public PropCityInfo()
  {

  }

  public PropCityInfo(long cityId, String cityName)
  {
    this.cityId = cityId;
    this.cityName = cityName;
  }

  public long getCityId()
  {
    return cityId;
  }

  public void setCityId(long cityId)
  {
    this.cityId = cityId;
  }

  public String getCityName()
  {
    return cityName;
  }

  public void setCityName(String cityName)
  {
    this.cityName = cityName;
  }

}
