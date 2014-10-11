package com.vstar.process.propertyDetailInfo;

public class ResidentialUnits {
	private String id;
	private String value;
	private String label;
	private boolean ticked;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isTicked() {
		return ticked;
	}

	public void setTicked(boolean ticked) {
		this.ticked = ticked;
	}

}
