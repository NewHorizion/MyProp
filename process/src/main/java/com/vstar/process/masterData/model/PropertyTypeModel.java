package com.vstar.process.masterData.model;

public class PropertyTypeModel {
	private Integer id;
	private String label;
	private String categoryName;
	private boolean ticket;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

  public String getCategoryName()
  {
    return categoryName;
  }

  public void setCategoryName(String categoryName)
  {
    this.categoryName = categoryName;
  }

  public boolean isTicket()
  {
    return ticket;
  }

  public void setTicket(boolean ticket)
  {
    this.ticket = ticket;
  }

}
