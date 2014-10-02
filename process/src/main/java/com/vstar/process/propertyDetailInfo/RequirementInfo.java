package com.vstar.process.propertyDetailInfo;

import com.vstar.process.masterData.model.LocalityModel;
import com.vstar.process.masterData.model.PropertyTypeModel;

/**
 * Requirement Info Bean
 *
 */
public class RequirementInfo
{
  private PropertyTypeModel[] propertyTypes;
  private LocalityModel[] locations;
  private int city;
  private int purchaseType;
  private int minCoveredArea;
  private int maxCoveredArea;
  private ResidentialUnits coveredAreaUnit;
  private ResidentialUnits minBudget;
  private ResidentialUnits maxBudget;
  private boolean dealingType;
  private int minPlotArea;
  private int maxPlotArea;
  private ResidentialUnits plotAreaUnit;
  private ResidentialUnits minBedrooms;
  private ResidentialUnits maxBedrooms;
  private ResidentialUnits []budget;
  private ResidentialUnits []bedroom;

  public int getMinCoveredArea()
  {
    return minCoveredArea;
  }

  public void setMinCoveredArea(int minCoveredArea)
  {
    this.minCoveredArea = minCoveredArea;
  }

  public int getMaxCoveredArea()
  {
    return maxCoveredArea;
  }

  public void setMaxCoveredArea(int maxCoveredArea)
  {
    this.maxCoveredArea = maxCoveredArea;
  }

  public boolean getDealingType()
  {
    return dealingType;
  }

  public void setDealingType(boolean dealingType)
  {
    this.dealingType = dealingType;
  }

  public int getMinPlotArea()
  {
    return minPlotArea;
  }

  public void setMinPlotArea(int minPlotArea)
  {
    this.minPlotArea = minPlotArea;
  }

  public int getMaxPlotArea()
  {
    return maxPlotArea;
  }

  public void setMaxPlotArea(int maxPlotArea)
  {
    this.maxPlotArea = maxPlotArea;
  }
  
  public int getPurchaseType()
  {
    return purchaseType;
  }

  public void setPurchaseType(int purchaseType)
  {
    this.purchaseType = purchaseType;
  }

  public ResidentialUnits getMinBedrooms()
  {
    return minBedrooms;
  }

  public void setMinBedrooms(ResidentialUnits minBedrooms)
  {
    this.minBedrooms = minBedrooms;
  }

  public ResidentialUnits getMaxBedrooms()
  {
    return maxBedrooms;
  }

  public void setMaxBedrooms(ResidentialUnits maxBedrooms)
  {
    this.maxBedrooms = maxBedrooms;
  }

  public LocalityModel[] getLocations()
  {
    return locations;
  }

  public void setLocations(LocalityModel[] locations)
  {
    this.locations = locations;
  }

  public ResidentialUnits getCoveredAreaUnit()
  {
    return coveredAreaUnit;
  }

  public void setCoveredAreaUnit(ResidentialUnits coveredAreaUnit)
  {
    this.coveredAreaUnit = coveredAreaUnit;
  }

  public ResidentialUnits getPlotAreaUnit()
  {
    return plotAreaUnit;
  }

  public void setPlotAreaUnit(ResidentialUnits plotAreaUnit)
  {
    this.plotAreaUnit = plotAreaUnit;
  }

  public ResidentialUnits getMinBudget()
  {
    return minBudget;
  }

  public void setMinBudget(ResidentialUnits minBudget)
  {
    this.minBudget = minBudget;
  }

  public ResidentialUnits getMaxBudget()
  {
    return maxBudget;
  }

  public void setMaxBudget(ResidentialUnits maxBudget)
  {
    this.maxBudget = maxBudget;
  }

  public int getCity()
  {
    return city;
  }

  public void setCity(int city)
  {
    this.city = city;
  }

  public PropertyTypeModel[] getPropertyTypes()
  {
    return propertyTypes;
  }

  public void setPropertyTypes(PropertyTypeModel[] propertyTypes)
  {
    this.propertyTypes = propertyTypes;
  }

  public ResidentialUnits[] getBudget()
  {
    return budget;
  }

  public void setBudget(ResidentialUnits[] budget)
  {
    this.budget = budget;
  }

  public ResidentialUnits[] getBedroom()
  {
    return bedroom;
  }

  public void setBedroom(ResidentialUnits[] bedroom)
  {
    this.bedroom = bedroom;
  }

}
