package com.vstar.process.propertyDetailInfo;

import com.vstar.process.masterData.infoBean.PropLocationInfo;

/**
 * Capturing Property Mandate Features
 */
public class PropertyMandateInfo
{
  private String purchaseType;
  private long propertyTypeId;
  private PropLocationInfo propLocationInfo;
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

  public PropLocationInfo getPropLocationInfo()
  {
    return propLocationInfo;
  }

  public void setPropLocationInfo(PropLocationInfo propLocationInfo)
  {
    this.propLocationInfo = propLocationInfo;
  }

}
