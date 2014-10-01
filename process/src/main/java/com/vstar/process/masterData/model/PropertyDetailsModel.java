package com.vstar.process.masterData.model;

public class PropertyDetailsModel {
	private String propertyTitle;
	private String projectName;
	private String developerName;
	private String propertyPrice;
	private String perSqFtRate;
	private String propertyDescription;
	private String coveredArea;
	private String plotArea;
	private String propertyImagePath;
	private String propertyThumbImagePath;
    private String propertyId; 
    
	public String getPropertyTitle() {
		return propertyTitle;
	}

	public void setPropertyTitle(String propertyTitle) {
		this.propertyTitle = propertyTitle;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDeveloperName() {
		return developerName;
	}

	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}

	public String getPropertyPrice() {
		return propertyPrice;
	}

	public void setPropertyPrice(String propertyPrice) {
		this.propertyPrice = propertyPrice;
	}

	public String getPerSqFtRate() {
		return perSqFtRate;
	}

	public void setPerSqFtRate(String perSqFtRate) {
		this.perSqFtRate = perSqFtRate;
	}

	public String getPropertyDescription() {
		return propertyDescription;
	}

	public void setPropertyDescription(String propertyDescription) {
		this.propertyDescription = propertyDescription;
	}

	public String getPropertyImagePath() {
		return propertyImagePath;
	}

	public void setPropertyImagePath(String propertyImagePath) {
		this.propertyImagePath = propertyImagePath;
	}

	public String getPropertyThumbImagePath() {
		return propertyThumbImagePath;
	}

	public void setPropertyThumbImagePath(String propertyThumbImagePath) {
		this.propertyThumbImagePath = propertyThumbImagePath;
	}

  public String getCoveredArea()
  {
    return coveredArea;
  }

  public void setCoveredArea(String coveredArea)
  {
    this.coveredArea = coveredArea;
  }

  public String getPlotArea()
  {
    return plotArea;
  }

  public void setPlotArea(String plotArea)
  {
    this.plotArea = plotArea;
  }

public String getPropertyId() {
	return propertyId;
}

public void setPropertyId(String propertyId) {
	this.propertyId = propertyId;
}

}
