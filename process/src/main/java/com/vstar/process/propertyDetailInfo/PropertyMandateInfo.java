package com.vstar.process.propertyDetailInfo;

import org.codehaus.stax2.LocationInfo;

/**
 * Capturing Property Mandate Features
 */
public class PropertyMandateInfo
{
  private String purchaseType;
  private long propertyTypeId;
  private LocationInfo location;
  private int coveredArea;
  private long propPrice;
  private String transactionType;

  public String getPurchaseType()
  {
    return purchaseType;
  }

  public void setPurchaseType(String purchaseType)
  {
    this.purchaseType = purchaseType;
  }

  public long getPropertyTypeId()
  {
    return propertyTypeId;
  }

  public void setPropertyTypeId(long propertyTypeId)
  {
    this.propertyTypeId = propertyTypeId;
  }

  public LocationInfo getLocation()
  {
    return location;
  }

  public void setLocation(LocationInfo location)
  {
    this.location = location;
  }

  public int getCoveredArea()
  {
    return coveredArea;
  }

  public void setCoveredArea(int coveredArea)
  {
    this.coveredArea = coveredArea;
  }

  public long getPropPrice()
  {
    return propPrice;
  }

  public void setPropPrice(long propPrice)
  {
    this.propPrice = propPrice;
  }

  public String getTransactionType()
  {
    return transactionType;
  }

  public void setTransactionType(String transactionType)
  {
    this.transactionType = transactionType;
  }

}
