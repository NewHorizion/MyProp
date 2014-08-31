package com.vstar.process.propertyDetailInfo;

import com.vstar.process.masterData.infoBean.PropLocationInfo;

/**
 * Capturing Property Mandate Features
 */
public class PropertyMandateInfo {
	private String purchaseType;
	private long propertyTypeId;
	private PropLocationInfo propLocationInfo;
	private int coveredArea;
	private long propPrice;
	private String transactionType;
	private String address;
	private int plotArea;
	private ResidentialUnits coveredAreaUnit;
	private ResidentialUnits plotAreaUnit;
	private String city;
	private String locality;

	public String getPurchaseType() {
		return purchaseType;
	}

	public void setPurchaseType(String purchaseType) {
		this.purchaseType = purchaseType;
	}

	public long getPropertyTypeId() {
		return propertyTypeId;
	}

	public void setPropertyTypeId(long propertyTypeId) {
		this.propertyTypeId = propertyTypeId;
	}

	public int getCoveredArea() {
		return coveredArea;
	}

	public void setCoveredArea(int coveredArea) {
		this.coveredArea = coveredArea;
	}

	public long getPropPrice() {
		return propPrice;
	}

	public void setPropPrice(long propPrice) {
		this.propPrice = propPrice;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public PropLocationInfo getPropLocationInfo() {
		return propLocationInfo;
	}

	public void setPropLocationInfo(PropLocationInfo propLocationInfo) {
		this.propLocationInfo = propLocationInfo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public int getPlotArea() {
		return plotArea;
	}

	public void setPlotArea(int plotArea) {
		this.plotArea = plotArea;
	}

	public ResidentialUnits getCoveredAreaUnit() {
		return coveredAreaUnit;
	}

	public void setCoveredAreaUnit(ResidentialUnits coveredAreaUnit) {
		this.coveredAreaUnit = coveredAreaUnit;
	}

	public ResidentialUnits getPlotAreaUnit() {
		return plotAreaUnit;
	}

	public void setPlotAreaUnit(ResidentialUnits plotAreaUnit) {
		this.plotAreaUnit = plotAreaUnit;
	}

}
