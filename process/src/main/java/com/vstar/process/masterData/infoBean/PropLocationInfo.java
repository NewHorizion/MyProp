package com.vstar.process.masterData.infoBean;

/**
 * Info Bean for passing Location Data 
 *
 */
public class PropLocationInfo
{
  private long locationId;
  private String locationName;
  private boolean ticked;

  public PropLocationInfo()
  {

  }

  public PropLocationInfo(long locationId, String locationName)
  {
    this.locationId = locationId;
    this.locationName = locationName;
  }
  
  /**
   * Equating two objects
   * 
   * @param propLocationInfo
   * @return
   */
  @Override
  public boolean equals(Object object)
  {
    if(object == null)
      return false;
    if(!(object instanceof PropLocationInfo)) 
      return false;

    PropLocationInfo propLocationInfo = (PropLocationInfo) object;
    return this.locationId == propLocationInfo.locationId;
  }

  public long getLocationId()
  {
    return locationId;
  }

  public void setLocationId(long locationId)
  {
    this.locationId = locationId;
  }

  public String getLocationName()
  {
    return locationName;
  }

  public void setLocationName(String locationName)
  {
    this.locationName = locationName;
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
